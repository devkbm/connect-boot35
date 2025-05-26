package com.like.system.user.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = {"userId"})
@Embeddable
public class SystemUserId implements Serializable {

	private static final long serialVersionUID = -8544637739358675046L;
	
	@Column(name="USER_ID")
	String userId;	
	
	public SystemUserId(String userId) {		
		this.userId = userId;
	}
		
}
