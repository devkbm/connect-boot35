package com.like.system.user.adapter.out.db;

import static org.springframework.util.StringUtils.hasText;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.user.adapter.out.db.data.SystemUserRepository;
import com.like.system.user.application.port.in.query.SystemUserQueryDTO;
import com.like.system.user.application.port.out.SystemUserQueryDbPort;
import com.like.system.user.domain.QSystemUser;
import com.like.system.user.domain.SystemUser;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

@Repository
public class SystemUserQueryDbAdapter implements SystemUserQueryDbPort {

	SystemUserRepository repository;
	
	private static final QSystemUser qType = QSystemUser.systemUser;
	
	SystemUserQueryDbAdapter(SystemUserRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<SystemUser> selectList(SystemUserQueryDTO dto) {
		return this.repository.findAll(condition(dto));
	}
	
	private BooleanBuilder condition(SystemUserQueryDTO dto) {
		BooleanBuilder builder = new BooleanBuilder();
		
		builder.and(eqOrganizationCode(dto.companyCode()))
			   .and(likeUserId(dto.userId()))
			   .and(likeUserName(dto.name()))
		 	   .and(equalDeptCode(dto.deptCode()));						
		
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
