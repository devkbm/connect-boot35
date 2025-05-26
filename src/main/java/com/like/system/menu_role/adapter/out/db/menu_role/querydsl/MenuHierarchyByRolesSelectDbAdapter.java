package com.like.system.menu_role.adapter.out.db.menu_role.querydsl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.menu_role.domain.menu.QMenu;
import com.like.system.menu_role.adapter.out.db.menu.querydsl.MenuHierarchyMapper;
import com.like.system.menu_role.application.port.out.menu_role.MenuHierarchyByRolesSelectDbPort;
import com.like.system.menu_role.domain.menu.MenuHierarchy;
import com.like.system.menu_role.domain.menu_role.QMenuRoleMapping;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class MenuHierarchyByRolesSelectDbAdapter implements MenuHierarchyByRolesSelectDbPort {

	JPAQueryFactory queryFactory;
	private final QMenu qMenu = QMenu.menu;
	private final QMenuRoleMapping qMenuRoleMapping = QMenuRoleMapping.menuRoleMapping;
	
	MenuHierarchyByRolesSelectDbAdapter(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
	
	@Override
	public List<MenuHierarchy> select(String companyCode, String menuGroupCode, List<String> roleCodes) {		
		return queryFactory
				.select(MenuHierarchyMapper.map(qMenu)).distinct()
				/*
				.select(Projections.fields(MenuHierarchy.class,
						qMenu.id.menuGroupId.companyCode,
						qMenu.id.menuGroupId.menuGroupCode,
						qMenu.id.menuCode,
						qMenu.name.as("menuName"),
						qMenu.type.as("menuType"),
						qMenu.appUrl,			
						qMenu.appIcon.appIconType,
						qMenu.appIcon.appIcon,
						qMenu.sequence,
						qMenu.level,
						qMenu.parentMenuCode
						)).distinct()
				*/
				.from(qMenu)
				.innerJoin(qMenuRoleMapping)
					.on(qMenu.id.menuGroupId.companyCode.eq(qMenuRoleMapping.id.companyCode)
					.and(qMenu.id.menuGroupId.menuGroupCode.eq(qMenuRoleMapping.id.menuGroupCode))
					.and(qMenu.id.menuCode.eq(qMenuRoleMapping.id.menuCode))	
					.and(qMenuRoleMapping.id.roleCode.in(roleCodes))
					)
				.where(qMenu.id.menuGroupId.companyCode.eq(companyCode)
					  ,qMenu.id.menuGroupId.menuGroupCode.eq(menuGroupCode)
					  )
				.orderBy(qMenu.sequence.asc())
				.fetch();
		
	}

}
