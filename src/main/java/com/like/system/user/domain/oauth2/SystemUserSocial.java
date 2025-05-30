package com.like.system.user.domain.oauth2;

import com.like.core.jpa.domain.AbstractAuditEntity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "COMUSERSOCIAL")
public class SystemUserSocial extends AbstractAuditEntity {

	@EmbeddedId
	SystemUserSocialId id;
	
	@Column(name="REG_ID")
	String registrationId;
	
	@Column(name="EMAIL")
	String email;
	
	public SystemUserSocial(
			SystemUserSocialId id,
			String registrationId,
			String email
			) {
		this.id = id;
		this.registrationId = registrationId;
		this.email = email;
	}
}
