package com.like.system.menu_role.adapter.out.db.menu_role.querydsl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.menu_role.application.port.out.menu_role.MenuRoleHierarchySelectDbPort;
import com.like.system.menu_role.domain.menu.QMenu;
import com.like.system.menu_role.domain.menu_role.MenuRoleHierarchy;
import com.like.system.menu_role.domain.menu_role.QMenuRoleMapping;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class MenuRoleHierarchyDbAdapter implements MenuRoleHierarchySelectDbPort {

	JPAQueryFactory queryFactory;
	private final QMenu qMenu = QMenu.menu;
	private final QMenuRoleMapping qMenuRoleMapping = QMenuRoleMapping.menuRoleMapping;
	
	MenuRoleHierarchyDbAdapter(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;		
	}
	
	@Override
	public List<MenuRoleHierarchy> select(String companyCode, String menuGroupCode, String roleCode) {
		Expression<Boolean> checked = new CaseBuilder()
				.when(qMenuRoleMapping.id.roleCode.isNotNull()).then(true)
				.otherwise(false)
				.as("checked");				
		
		return queryFactory
				.select(Projections.fields(MenuRoleHierarchy.class,
						qMenu.id.menuGroupId.companyCode,
						qMenu.id.menuGroupId.menuGroupCode,
						qMenu.id.menuCode,
						qMenu.name.as("menuName"),
						qMenuRoleMapping.id.roleCode,
						checked,
						qMenu.parentMenuCode
						))
				.from(qMenu)
				.leftJoin(qMenuRoleMapping)
					.on(qMenu.id.menuGroupId.companyCode.eq(qMenuRoleMapping.id.companyCode)
					.and(qMenu.id.menuGroupId.menuGroupCode.eq(qMenuRoleMapping.id.menuGroupCode))
					.and(qMenu.id.menuCode.eq(qMenuRoleMapping.id.menuCode))	
					.and(qMenuRoleMapping.id.roleCode.eq(roleCode))
					)
				.where(qMenu.id.menuGroupId.companyCode.eq(companyCode)
					  ,qMenu.id.menuGroupId.menuGroupCode.eq(menuGroupCode)
					  )
				.orderBy(qMenu.sequence.asc())
				.fetch();
	}

}
