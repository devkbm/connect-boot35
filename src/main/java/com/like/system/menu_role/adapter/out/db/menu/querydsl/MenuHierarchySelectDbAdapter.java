package com.like.system.menu_role.adapter.out.db.menu.querydsl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.menu_role.domain.menu.QMenu;
import com.like.system.menu_role.application.port.out.menu.MenuHierarchySelectDbPort;
import com.like.system.menu_role.domain.menu.MenuHierarchy;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class MenuHierarchySelectDbAdapter implements MenuHierarchySelectDbPort {

	JPAQueryFactory queryFactory;
	private final QMenu qMenu = QMenu.menu;
	
	MenuHierarchySelectDbAdapter(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
	
	@Override
	public List<MenuHierarchy> getAllFlattenNodes(String companyCode, String menuGroupCode) {
		return queryFactory
				.select(MenuHierarchyMapper.map(qMenu))
				
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
						))
						*/
				.from(qMenu)
				.where(qMenu.id.menuGroupId.companyCode.eq(companyCode)
					  ,qMenu.id.menuGroupId.menuGroupCode.eq(menuGroupCode))
				.orderBy(qMenu.parentMenuCode.asc(), qMenu.sequence.asc())				
				.fetch();
	}

}
