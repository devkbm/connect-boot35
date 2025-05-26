package com.like.system.user.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(of = {"userId", "companyCode"})
@Getter
@NoArgsConstructor
@Embeddable
public class SystemUserCompanyId implements Serializable {
	
	private static final long serialVersionUID = 2360915143791502459L;

	SystemUserId userId;	
	
	@Column(name="ORG_CD")
	String companyCode;
	
	public SystemUserCompanyId(String companyCode, String userId) {		
		this.userId = new SystemUserId(userId);
		this.companyCode = companyCode;
	}
	
}
