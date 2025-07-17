package com.like.system.user.domain.oauth2;

import com.like.core.jpa.domain.AbstractAuditEntity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 소셜 이메일 정보 관리
 */
@Getter
@NoArgsConstructor
@Entity
@Table(name = "COMUSERSOCIAL")
public class SystemUserSocialEmail extends AbstractAuditEntity {

	@EmbeddedId
	SystemUserSocialEmailId id;
	
	@Column(name="REG_ID")
	String registrationId;
	
	@Column(name="EMAIL")
	String email;
	
	public SystemUserSocialEmail(
			SystemUserSocialEmailId id,
			String registrationId,
			String email
			) {
		this.id = id;
		this.registrationId = registrationId;
		this.email = email;
	}
}
