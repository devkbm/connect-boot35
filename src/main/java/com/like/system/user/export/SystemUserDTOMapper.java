package com.like.system.user.export;

import java.util.Optional;

import com.like.system.dept.domain.Dept;
import com.like.system.user.domain.SystemUser;
import com.like.system.user.domain.SystemUserCompany;

import jakarta.persistence.EntityNotFoundException;

public class SystemUserDTOMapper {

	public static SystemUserDTO toDTO(SystemUser entity, String companyCode) {						
		if (entity == null) return null;
		
		SystemUserCompany company = entity.getCompanyInfo(companyCode).orElseThrow(() -> new EntityNotFoundException("회사 정보가 없습니다."));
		
		Optional<Dept> dept = Optional.ofNullable(company.getDept());			
		
		SystemUserDTO dto = SystemUserDTO.builder()								
										 .companyCode(company.getId().getCompanyCode())
										 .userId(entity.getId().getUserId())										 
										 .name(entity.getName())										 
										 .mobileNum(entity.getMobileNum())
										 .email(entity.getEmail())
										 .imageBase64(entity.getImage())
										 .enabled(true)											 
										 .staffNo(entity.getId().getUserId())
										 .deptCode(dept.map(r -> r.getId().getDeptCode()).orElse(""))
										 .deptName(dept.map(Dept::getDeptNameKorean).orElse(""))
										 .roleList(entity.getRoleList(companyCode)
												   		 .stream()
														 .map(auth -> auth.getAuthority())
														 .toList())										   
										 .build();
		
		return dto;
	}
}
