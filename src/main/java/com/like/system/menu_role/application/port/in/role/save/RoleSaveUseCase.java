package com.like.system.menu_role.application.port.in.role.save;

public interface RoleSaveUseCase {
	
	boolean exists(String companyCode, String roleCode);
	
	void save(RoleSaveDTO dto);
}
