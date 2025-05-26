package com.like.system.user.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(of = {"userId", "companyCode", "roleCode"})
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class SystemUserCompanyRoleId implements Serializable {
		
	private static final long serialVersionUID = 8341227268289327529L;
	
	SystemUserId userId;
		
	@Column(name="ORG_CD")
	private String companyCode;
	
	@Column(name="ROLE_CD")
	String roleCode;
	
	public SystemUserCompanyRoleId(String userId, String companyCode, String roleCode) {		
		this.userId = new SystemUserId(userId);
		this.companyCode = companyCode;
		this.roleCode = roleCode;
	}
}
