package com.like.system.menu_role.domain.role;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(of = {"companyCode","roleCode"})
public class RoleId {

	String companyCode;
	
	String roleCode;
	
	public RoleId(String companyCode, String roleCode) {
		this.companyCode = companyCode;
		this.roleCode = roleCode;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public String getRoleCode() {
		return roleCode;
	}
		
}
