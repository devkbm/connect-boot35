package com.like.system.user.application.port.in.save;

import java.time.LocalDateTime;
import java.util.List;

import com.like.system.dept.domain.Dept;
import com.like.system.user.domain.SystemUserAccountAttribute;
import com.like.system.user.domain.SystemUser;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record SystemUserSaveDTO(
		LocalDateTime createdDt,
		String createdBy,
		LocalDateTime modifiedDt,
		String modifiedBy,
		String clientAppUrl,
		String userId,
		@NotBlank(message="조직코드를 선택해 주세요.")
		String companyCode,
		@NotBlank(message="직원번호를 입력해 주세요.")
		String staffNo,
		String name,
		String deptCode,
		String deptName,
		String mobileNum,
		String email,
		String imageBase64,
		Boolean accountNonExpired,
		Boolean accountNonLocked,
		Boolean credentialsNonExpired,
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
				
	public void modifyUser(SystemUser user, Dept dept) {
					
		user.modifyBuilder()									
			.name(name)
			.mobileNum(mobileNum)
			.email(email)			
			.modify();
		
		user.setAppUrl(clientAppUrl);
	}
		
}
