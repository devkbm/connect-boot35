package com.like.system.user.application.port.in.upload;

import java.util.List;

import com.like.excel.upload.ExcelHeader;
import com.like.system.dept.domain.Dept;
import com.like.system.user.domain.SystemUserAccountAttribute;
import com.like.system.user.domain.SystemUser;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record SystemUserExcelUploadDTO(		
		String clientAppUrl,
		@ExcelHeader("사용자아이디") String userId,
		@NotBlank(message="조직코드를 선택해 주세요.")
		@ExcelHeader("회사코드") String companyCode,
		@NotBlank(message="직원번호를 입력해 주세요.")
		@ExcelHeader("직원번호") String staffNo,
		@ExcelHeader("직원명") String name,
		@ExcelHeader("부서코드") String deptCode,		
		@ExcelHeader("핸드폰번호") String mobileNum,
		@ExcelHeader("이메일") String email,			
		Boolean enabled,
		List<String> roleList,
		List<String> menuGroupList
		) {
	
	public SystemUser newUser(Dept dept) {
		SystemUser entity = SystemUser.builder()										  
									  .name(this.name)											  
									  .userId(this.staffNo)									  			
									  .mobileNum(this.mobileNum)
									  .email(this.email)					  
									  .accountSpec(new SystemUserAccountAttribute(true, true, true, true))										  										  			 
									  .build();
		
		entity.setAppUrl(clientAppUrl);
		
		return entity;			
	}
					
}
