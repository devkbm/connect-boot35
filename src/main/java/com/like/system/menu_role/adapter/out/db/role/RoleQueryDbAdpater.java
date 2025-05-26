package com.like.system.menu_role.adapter.out.db.role;

import static org.springframework.util.StringUtils.hasText;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.menu_role.adapter.out.db.role.jpa.RoleJpaEntity;
import com.like.system.menu_role.application.dto.role.RoleQueryDTO;
import com.like.system.menu_role.application.port.out.role.RoleQueryDbPort;
import com.like.system.menu_role.adapter.out.db.role.jpa.QRoleJpaEntity;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class RoleQueryDbAdpater implements RoleQueryDbPort {

	private JPAQueryFactory queryFactory;
	private final QRoleJpaEntity qEntity = QRoleJpaEntity.roleJpaEntity;	
	
	public RoleQueryDbAdpater(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;		
	}
	
	@Override
	public List<RoleJpaEntity> getRoleList(RoleQueryDTO dto) {		
		return queryFactory
				.selectFrom(qEntity)
				.where(toPredicate(dto))
				.fetch();
		
	}
	
	public BooleanBuilder toPredicate(RoleQueryDTO dto) {
		BooleanBuilder builder = new BooleanBuilder();
		QRoleJpaEntity qType = QRoleJpaEntity.roleJpaEntity;
			
		builder.and(qType.id.companyCode.eq(dto.companyCode()));
		
		if (hasText(dto.roleCode())) {
			builder.and(qType.id.roleCode.like("%"+dto.roleCode()+"%"));
		}
		
		if (hasText(dto.description())) {
			builder.and(qType.description.like("%"+dto.description()+"%"));
		}
		
		if (hasText(dto.menuGroupCode())) {
			builder.and(qType.menuGroupCode.eq(dto.menuGroupCode()));
		}
		
		return builder;
	}

}
