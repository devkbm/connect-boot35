package com.like.system.menu_role.domain.role;

import lombok.Getter;

@Getter
public class Role {
	
	String appUrl;
	
	RoleId id;
	
	String roleName;
		
	String description;		
	
	String menuGroupCode;
		
	public Role(
			String appUrl,
			String companyCode, 
			String roleCode, 
			String roleName, 
			String description, 
			String menuGroupCode
			) {		
		this.appUrl = appUrl;
		this.id = new RoleId(companyCode, roleCode);		
		this.roleName = roleName;
		this.description = description;		
		this.menuGroupCode = menuGroupCode;
	}	
	
	public void modify(
			String appUrl,
			String roleName, 
			String description, 
			String menuGroupCode
			) {
		this.appUrl = appUrl;
		this.roleName = roleName;
		this.description = description;
		this.menuGroupCode = menuGroupCode;
	}	
		
	public String getCompanyCode() {
		return this.id.getCompanyCode();
	}

	public String getRoleCode() {
		return this.id.getRoleCode();
	}
		
}
