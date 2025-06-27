package com.like.system.user.application.port.in.query;

import static org.springframework.util.StringUtils.hasText;

import com.like.system.user.domain.QSystemUser;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

import jakarta.validation.constraints.NotBlank;

public record SystemUserQueryDTO(
		@NotBlank(message="조직 코드를 선택해주세요.")
		String companyCode,
		String userId,			
		String name,
		String deptCode
		) {
	private static final QSystemUser qType = QSystemUser.systemUser;
	
	public BooleanBuilder getBooleanBuilder() {
		BooleanBuilder builder = new BooleanBuilder();
		
		builder.and(eqOrganizationCode(this.companyCode))
			   .and(likeUserId(this.userId))
			   .and(likeUserName(this.name))
		 	   .and(equalDeptCode(this.deptCode));						
		
		return builder;
	}
	
	private BooleanExpression eqOrganizationCode(String companyCode) {
		//return qType.staffId.companyCode.eq(companyCode);
		return null;
	}
			
	private BooleanExpression likeUserId(String userId) {
		return hasText(userId) ? qType.id.userId.like("%"+userId+"%") : null;		
	}
	
	private BooleanExpression likeUserName(String name) {
		return hasText(name) ? qType.name.like("%"+name+"%") : null;					
	}
	
	private BooleanExpression equalDeptCode(String deptCode) {
		//return hasText(deptCode) ? qType.dept.id.deptCode.eq(deptCode) : null;
		return null;
	}
}
