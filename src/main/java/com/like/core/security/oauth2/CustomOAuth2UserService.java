package com.like.core.security.oauth2;

import java.util.Optional;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.user.adapter.out.db.data.SystemUserRepository;
import com.like.system.user.domain.QSystemUser;
import com.like.system.user.domain.SystemUser;
import com.like.system.user.domain.SystemUserId;

// http://localhost:8090/oauth2/authorization/google
@Transactional
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User>{
	
	private final SystemUserRepository userRepository;
	private final SocialLoginRepository socialLoginRepository;
		   
	CustomOAuth2UserService(SystemUserRepository userRepository
						   ,SocialLoginRepository socialLoginRepository) {
		this.userRepository = userRepository;		
		this.socialLoginRepository = socialLoginRepository;
	}
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
					
		OAuth2UserService delegate = new DefaultOAuth2UserService();
		OAuth2User oAuth2User = delegate.loadUser(userRequest);			
		
		String registrationId = userRequest.getClientRegistration().getRegistrationId();
		String userNameAttributeName = userRequest.getClientRegistration()
												  .getProviderDetails()
												  .getUserInfoEndpoint()
												  .getUserNameAttributeName();
		
		OAuth2Attributes attributes = OAuth2Attributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());
		
		
		// {sub=112050878942662954589, name=김병민, given_name=병민, family_name=김, picture=https://lh3.googleusercontent.com/a/ACg8ocIMTjbjyQTYA9qtpQisXrW2rh5DaP4Vh3lQiHL8o14qwrj_oA=s96-c, email=devkbm0417@gmail.com, email_verified=true}
		/*
		log.info("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		log.info(oAuth2User.getAttributes().get(userNameAttributeName).toString());
		log.info(oAuth2User.getAttributes().toString());		
		
		log.info(registrationId);
		log.info(userNameAttributeName);		
		log.info(attributes.getNameAttributeKey());
		log.info(attributes.getAttributes().toString());
		log.info("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			
		*/				
		 
		// 1. 유저 키로 소셜 로그인 정보가 있는지 검사
		SocialLogin socialLoginInfo = this.findSocialLoginInfo(new SocialLoginID(registrationId, oAuth2User.getAttributes().get(userNameAttributeName).toString()))
										  .orElse(null);		
		
		String companyCode = OAuth2LoginRequestThreadLocal.get();
		SystemUser systemUser = null;
		// 2. 로그인 정보가 없을 경우 사용자 정보에서 이메일이 동일한 사용자 검색하여
		//    소셜 로그인 정보 저장
		if (socialLoginInfo == null) {
	
			systemUser = this.findSystemUserByEmail(oAuth2User.getAttributes().get("email").toString())
 			 		         .orElseThrow(() -> new RuntimeException("동일한 이메일 정보를 가진 사용자가 없습니다."));
			
			socialLoginInfo = SocialLogin.newSocialLogin(new SocialLoginID(registrationId, oAuth2User.getAttributes().get(userNameAttributeName).toString())
														,systemUser.getId().getUserId()									
														,oAuth2User.getAttribute("name")
														,oAuth2User.getAttribute("email")														
														);
			
			saveSocialLoginInfo(socialLoginInfo);
		} else {					
			systemUser = findSystemUser(socialLoginInfo.getUserId())
							.orElseThrow(() -> new RuntimeException("사용자가 없습니다."));			
		}			
				
		OAuth2User oAuth2 = new SystemOauth2User(
				   systemUser.getId().getUserId(),
				   systemUser.getName(),
				   systemUser.getRoleList(companyCode),
	               attributes.getNameAttributeKey(),
	               attributes.getAttributes()
	               );  
		
		return oAuth2;       
	}
	
	private Optional<SystemUser> findSystemUserByEmail(String email) {		
		return this.userRepository.findBy(QSystemUser.systemUser.email.eq(email), q-> q.first());
	}
	
	private Optional<SystemUser> findSystemUser(String userId) {
		
		return this.userRepository.findById(new SystemUserId(userId));
	}
	
	private Optional<SocialLogin> findSocialLoginInfo(SocialLoginID id) {
		return this.socialLoginRepository.findById(id);
	}
	
	private void saveSocialLoginInfo(SocialLogin entity) {
		this.socialLoginRepository.save(entity);
	}

}
