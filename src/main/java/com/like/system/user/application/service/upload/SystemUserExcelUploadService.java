package com.like.system.user.application.service.upload;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.like.system.dept.application.port.out.DeptCommandDbPort;
import com.like.system.dept.domain.Dept;
import com.like.system.user.application.port.in.upload.SystemUserExcelUploadUseCase;
import com.like.system.user.application.port.in.upload.SystemUserExcelUploadDTO2;
import com.like.system.user.application.port.out.SystemUserCommandDbPort;
import com.like.system.user.application.port.out.SystemUserCompanyCommandDbPort;
import com.like.system.user.application.port.out.SystemUserRoleCommandDbPort;
import com.like.system.user.domain.SystemUser;
import com.like.system.user.domain.SystemUserCompany;
import com.like.system.user.domain.SystemUserCompanyRole;
import com.like.system.user.domain.SystemUserPassword;

@Service
public class SystemUserExcelUploadService implements SystemUserExcelUploadUseCase {

	SystemUserCommandDbPort dbPort;		
	SystemUserRoleCommandDbPort userRoleDbPort;
	SystemUserCompanyCommandDbPort userCompanyDbPort;
	DeptCommandDbPort deptDbPort;
	PasswordEncoder passwordEncoder;
	
	SystemUserExcelUploadService(
			SystemUserCommandDbPort dbPort,						  
			SystemUserRoleCommandDbPort userRoleDbPort,
			SystemUserCompanyCommandDbPort userCompanyDbPort, 
			DeptCommandDbPort deptDbPort,
			PasswordEncoder passwordEncoder) {
		this.dbPort = dbPort;		
		this.userRoleDbPort = userRoleDbPort;
		this.userCompanyDbPort = userCompanyDbPort;
		this.deptDbPort = deptDbPort;
		this.passwordEncoder = passwordEncoder;		
	}
	
	@Override
	public void save(List<SystemUserExcelUploadDTO2> dtos) {
		for(SystemUserExcelUploadDTO2 dto : dtos ) {
			
			Dept dept = StringUtils.hasText(dto.getDeptCode()) ? deptDbPort.select(dto.getCompanyCode(), dto.getDeptCode()).orElse(null) : null;
			SystemUser user = this.dbPort.select(dto.getUserId()).orElse(null);
			
			if (user == null) {
				user = dto.newUser(dept);
				user.setPassword(passwordEncoder, SystemUserPassword.getInitPassword());
			} else {
				//dto.modifyUser(user, dept);
			}							
					
			this.dbPort.save(user);
			
			SystemUserCompany userCompany = new SystemUserCompany(user, dto.getCompanyCode(), dto.getDeptCode(), true); 
			this.userCompanyDbPort.save(userCompany);
			
			if (user.getRoleList(dto.getCompanyCode()).size() > 0) {
				this.userRoleDbPort.delete(user.getRoleList(dto.getCompanyCode()).stream().toList());
			}										
			this.userRoleDbPort.save(this.toSystemUserRole(dto, user));		
		}
	}
	
	private List<SystemUserCompanyRole> toSystemUserRole(SystemUserExcelUploadDTO2 dto, SystemUser user) {
		// String userId, String companyCode, String roleCode
		return this.userRoleDbPort.select(dto.getCompanyCode(), dto.getRoleList())
								  .stream()
								  .map(e -> new SystemUserCompanyRole(user, dto.getCompanyCode(), e.getRoleCode()))
								  .toList();
	}

}
