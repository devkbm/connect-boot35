package com.like.system.user.application.port.in.query;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SystemUserQueryResultDTO {
		LocalDateTime createdDt;
		String createdBy;
		LocalDateTime modifiedDt;
		String modifiedBy;
		String clientAppUrl;
		String userId;		
		String companyCode;	
		String staffNo;
		String name;
		String deptCode;
		String deptName;
		String mobileNum;
		String email;
		String imageBase64;
		Boolean accountNonExpired;
		Boolean accountNonLocked;
		Boolean credentialsNonExpired;
		Boolean enabled;
		String roleList;
		String menuGroupList;							
}
