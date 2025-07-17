package com.like.core.security.oauth2;

import java.util.Optional;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.core.security.oauth2.social.SocialLogin;
import com.like.core.security.oauth2.social.SocialLoginID;
import com.like.core.security.oauth2.social.SocialLoginRepository;
import com.like.system.user.adapter.out.db.data.SystemUserRepository;
import com.like.system.user.adapter.out.db.data.SystemUserSocialRepository;
import com.like.system.user.domain.SystemUser;
import com.like.system.user.domain.SystemUserId;
import com.like.system.user.domain.oauth2.QSystemUserSocialEmail;
import com.like.system.user.domain.oauth2.SystemUserSocialEmail;

import lombok.extern.slf4j.Slf4j;

// http://localhost:8090/oauth2/authorization/google
@Slf4j
@Transactional
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User>{
	
	private final SystemUserRepository userRepository;
	private final SystemUserSocialRepository userSocialRepository;
	private final SocialLoginRepository socialLoginRepository;
		   
	CustomOAuth2UserService(
			SystemUserRepository userRepository,
			SystemUserSocialRepository userSocialRepository,
			SocialLoginRepository socialLoginRepository
			) {
		this.userRepository = userRepository;		
		this.userSocialRepository = userSocialRepository;
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
				
		log.info(registrationId);
		log.info(userNameAttributeName);				
		log.info(attributes.getAttributes().toString());
											
		// 1. 유저 키로 소셜 로그인 정보가 있는지 검사
		String code = attributes.getId();
		SocialLoginID socialLoginId = new SocialLoginID(registrationId, code);
		SocialLogin socialLoginInfo = this.findSocialLoginInfo(socialLoginId).orElse(null);		
				
		SystemUser systemUser = null;
			
		// 2. 소셜 로그인 정보가 없을 경우 사용자 정보에서 이메일이 동일한 사용자 검색하여 소셜 로그인 정보 생성 (최초 로그인)
		if (socialLoginInfo == null) {			
			systemUser = this.findSystemUserBySocialEmail(attributes.getEmail()).orElseThrow(() -> new RuntimeException("동일한 이메일 정보를 가진 사용자가 없습니다."));
	
			this.saveSocialLoginInfo(
					socialLoginId,
					systemUser.getId().getUserId(),									
					oAuth2User.getAttribute("name"),
					oAuth2User.getAttribute("email")
					);					
		} else {
		// 3. 소셜 로그인 정보에 매핑된 사용자정보 조회
			systemUser = findSystemUser(socialLoginInfo.getUserId()).orElseThrow(() -> new RuntimeException("사용자가 없습니다."));
		}
					
		String companyCode = OAuth2LoginRequestThreadLocal.get();
		
		OAuth2User oAuth2 = new SystemOauth2User(
				   systemUser.getId().getUserId(),
				   systemUser.getName(),
				   systemUser.getRoleList(companyCode),
	               attributes.getNameAttributeKey(),
	               attributes.getAttributes()
	               );  
		
		return oAuth2;       
	}
	
	private void saveSocialLoginInfo(
			SocialLoginID id,
			String userId,						 
			String name,
			String email
			) {		
		SocialLogin socialLoginInfo = SocialLogin.newSocialLogin(id, userId, name, email);
				
		saveSocialLoginInfo(socialLoginInfo);		
	}
		
	private Optional<SystemUser> findSystemUserBySocialEmail(String email) {
		Optional<SystemUserSocialEmail> social = this.userSocialRepository.findBy(QSystemUserSocialEmail.systemUserSocialEmail.email.eq(email), q-> q.first());
		
		String userId = social.map(e -> e.getId().userId()).orElseThrow(() -> new RuntimeException("동일한 이메일 정보를 가진 사용자가 없습니다."));
		
		return this.userRepository.findById(new SystemUserId(userId));
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
