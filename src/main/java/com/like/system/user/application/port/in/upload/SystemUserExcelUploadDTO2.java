package com.like.system.user.application.port.in.upload;

import java.util.List;

import com.like.excel.upload.ExcelHeader;
import com.like.system.dept.domain.Dept;
import com.like.system.user.domain.SystemUser;
import com.like.system.user.domain.SystemUserAccountAttribute;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SystemUserExcelUploadDTO2 {

	String clientAppUrl;
	@ExcelHeader("사용자아이디") String userId;	
	@ExcelHeader("회사코드") String companyCode;	
	@ExcelHeader("직원번호") String staffNo;
	@ExcelHeader("직원명") String name;
	@ExcelHeader("부서코드") String deptCode;		
	@ExcelHeader("핸드폰번호") String mobileNum;
	@ExcelHeader("이메일") String email;			
	@ExcelHeader("사용여부")Boolean enabled;
	@ExcelHeader("롤리스트")List<String> roleList;	
	
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
