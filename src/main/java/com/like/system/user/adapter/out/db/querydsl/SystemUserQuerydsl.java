package com.like.system.user.adapter.out.db.querydsl;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.like.system.user.application.port.in.query.SystemUserQueryDTO;
import com.like.system.user.application.port.in.query.SystemUserQueryResultDTO;
import com.like.system.user.domain.QSystemUser;
import com.like.system.user.domain.QSystemUserCompanyRole;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class SystemUserQuerydsl {
	
	final QSystemUser qSystemUser = QSystemUser.systemUser;
	final QSystemUserCompanyRole qSystemUserCompanyRole = QSystemUserCompanyRole.systemUserCompanyRole;
	
	JPAQueryFactory queryFactory;
	
	SystemUserQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
	
	public List<SystemUserQueryResultDTO> selectList2(SystemUserQueryDTO dto) {
									
		return this.queryFactory
				.select(
					Projections.fields(
							SystemUserQueryResultDTO.class,
							qSystemUser.id.userId,
							qSystemUserCompanyRole.id.roleCode.as("roleList")							
					)					
				)
				.from(qSystemUser)
				.join(qSystemUserCompanyRole)
				.on(qSystemUser.id.userId.eq(qSystemUserCompanyRole.id.userId.userId)
					.and(qSystemUserCompanyRole.id.companyCode.eq(dto.companyCode())))				
				.where(qSystemUser.id.userId.eq(dto.userId()))				
				.groupBy(qSystemUser.id.userId)
				.fetch();							

	}

}
