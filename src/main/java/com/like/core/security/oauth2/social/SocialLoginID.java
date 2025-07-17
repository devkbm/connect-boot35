package com.like.core.security.oauth2.social;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor
@EqualsAndHashCode(of = {"registrationId","code"})
@Embeddable
public class SocialLoginID implements Serializable {

	private static final long serialVersionUID = 92268025401512259L;

	@Column(name="REG_ID")
	String registrationId;
	
	@Column(name="CODE")
	String code;		
}
