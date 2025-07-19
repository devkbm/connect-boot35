package com.like.system.user.adapter.out.db;

import static org.springframework.util.StringUtils.hasText;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.user.adapter.out.db.data.SystemUserRepository;
import com.like.system.user.adapter.out.db.mybatis.SystemUserMapper;
import com.like.system.user.adapter.out.db.querydsl.SystemUserQuerydsl;
import com.like.system.user.application.port.in.query.SystemUserQueryDTO;
import com.like.system.user.application.port.in.query.SystemUserQueryResultDTO2;
import com.like.system.user.application.port.out.SystemUserQueryDbPort;
import com.like.system.user.domain.QSystemUser;
import com.like.system.user.domain.SystemUser;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

@Repository
public class SystemUserQueryDbAdapter implements SystemUserQueryDbPort {

	SystemUserRepository repository;
	
	SystemUserQuerydsl querydsl;
	SystemUserMapper mapper;
	
	private static final QSystemUser qType = QSystemUser.systemUser;
	
	SystemUserQueryDbAdapter(
			SystemUserRepository repository,
			SystemUserQuerydsl querydsl,
			SystemUserMapper mapper
			) {
		this.repository = repository;
		this.querydsl = querydsl;
		this.mapper = mapper;
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

	@Override
	public List<SystemUserQueryResultDTO2> selectList2(SystemUserQueryDTO dto) {
		return this.mapper.selectList2(dto);
		//return this.querydsl.selectList2(dto);
	}
		
}
