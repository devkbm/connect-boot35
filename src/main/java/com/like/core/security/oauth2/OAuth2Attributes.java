package com.like.core.security.oauth2;

import java.util.Map;

import com.like.system.user.domain.SystemUser;

import lombok.Builder;
import lombok.Getter;

// https://blog.naver.com/slayra/223159711745

@Getter
public class OAuth2Attributes {

	private Map<String, Object> attributes;
	private String nameAttributeKey;
	private String id;
	private String name;
	private String email;
	private String picture;

	@Builder
	public OAuth2Attributes(
			Map<String, Object> attributes,
			String nameAttributeKey,
			String id,
			String name,
			String email,
			String picture
			) {
		this.attributes = attributes;
		this.nameAttributeKey= nameAttributeKey;
		this.id = id;
		this.name = name;
		this.email = email;
		this.picture = picture;
	}

	public static OAuth2Attributes of(
			String registrationId,
			String userNameAttributeName,
			Map<String, Object> attributes
			) {
					
		if (OAuth2Provider.GOOGLE.getRegistrationId().equals(registrationId)) {
			return ofGoogle(userNameAttributeName, attributes);
		} else if (OAuth2Provider.KAKAO.getRegistrationId().equals(registrationId)) {
			return ofKakao(userNameAttributeName, attributes);
		} else if (OAuth2Provider.NAVER.getRegistrationId().equals(registrationId)) {
			return ofNaver(userNameAttributeName, attributes);
		}
		
		return ofGoogle(userNameAttributeName, attributes);
	}

	private static OAuth2Attributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
		
		/*
		registrationId - google
		userNameAttributeName - sub
		attributes - {sub=112050878942662954589, name=김병민, given_name=병민, family_name=김, picture=https://lh3.googleusercontent.com/a/ACg8ocIMTjbjyQTYA9qtpQisXrW2rh5DaP4Vh3lQiHL8o14qwrj_oA=s96-c, email=devkbm0417@gmail.com, email_verified=true}
		*/
		
	    return OAuth2Attributes
	    		.builder()
	    		.nameAttributeKey(userNameAttributeName)
	    		.id((String) attributes.get("sub"))
	    		.name((String) attributes.get("name"))
	            .email((String) attributes.get("email"))
	            .picture((String) attributes.get("picture"))
	            .attributes(attributes)	              
	            .build();
	}
	
	private static OAuth2Attributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
		
		/*
		registrationId - kakao
		userNameAttributeName - id
		attributes - {id=4283957199, connected_at=2025-05-30T13:28:10Z, properties={nickname=김병민}, kakao_account={profile_nickname_needs_agreement=false, profile={nickname=김병민, is_default_nickname=false}, has_email=true, email_needs_agreement=false, is_email_valid=true, is_email_verified=true, email=kbm0417@nate.com}}
		*/
		
		Map<String, Object> response = (Map<String, Object>) attributes.get("properties");
        Map<String, Object> account = (Map<String, Object>) attributes.get("kakao_account");
		
	    return OAuth2Attributes
	    		.builder()
	    		.nameAttributeKey(userNameAttributeName)
	    		.id(attributes.get("id").toString())
	    		.name((String) response.get("nickname"))
	            .email((String) account.get("email"))
	            .picture((String) response.get("profile_image"))
	            .attributes(attributes)	              
	            .build();
	}
	
	private static OAuth2Attributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
		
		/*
		registrationId - naver
		userNameAttributeName - response
		attributes - {resultcode=00, message=success, response={id=MCZYDvhCe37esRIZesubKTlkpk_GgFKPGNxZbSwjsnQ, profile_image=https://ssl.pstatic.net/static/pwe/address/img_profile.png, email=nayabyungmin@naver.com, name=김병민}}
		*/		
		
		Map<String, Object> response = (Map<String, Object>) attributes.get("response");
		
	    return OAuth2Attributes
	    		.builder()
	    		.nameAttributeKey(userNameAttributeName)
	    		.id((String) response.get("id"))
	    		.name((String) response.get("name"))
	            .email((String) response.get("email"))
	            .picture((String) response.get("profile_image"))
	            .attributes(attributes)	              
	            .build();
	}


	public SystemUser toEntity() {
		return SystemUser.builder()
				   .name(name)
				   .email(email)
				   //.picture(picture)
				   //.role(Role.GUSET)
				   .build();
	}
}
