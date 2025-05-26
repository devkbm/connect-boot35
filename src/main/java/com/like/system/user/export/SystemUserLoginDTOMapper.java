package com.like.system.user.export;

import com.like.system.user.domain.SystemUser;

public class SystemUserLoginDTOMapper {

	public static SystemUserLoginDTO toDTO(SystemUser entity, String companyCode) {
		if (entity == null) return null;
		
		return SystemUserLoginDTO
				.builder()
				.companyCode(companyCode)
				.staffNo(entity.getId().getUserId())
				.authorities(entity.getRoleList(companyCode))
				.build();
	}
}
