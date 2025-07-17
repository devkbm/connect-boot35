package com.like.system.user.domain.oauth2;

import java.io.Serializable;

import com.like.system.user.domain.SystemUserId;

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
@EqualsAndHashCode(of = {"userId", "seq"})
@Embeddable
public class SystemUserSocialEmailId implements Serializable {

	private static final long serialVersionUID = -8963960540472374338L;

	SystemUserId userId;
	
	@Column(name="SEQ")
	Long seq;	
				
	public SystemUserSocialEmailId(String userId, Long seq) {
		this.userId = new SystemUserId(userId);
		this.seq = seq;
	}
	
	public String userId() {
		return this.userId.getUserId();
	}
	
	public Long seq() {
		return this.seq;
	}
}
