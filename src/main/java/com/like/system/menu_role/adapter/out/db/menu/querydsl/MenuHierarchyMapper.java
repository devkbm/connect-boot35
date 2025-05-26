package com.like.system.menu_role.adapter.out.db.menu.querydsl;

import com.like.system.menu_role.domain.menu.MenuHierarchy;
import com.like.system.menu_role.domain.menu.QMenu;
import com.like.system.webresource.domain.QWebResource;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.QBean;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.JPAExpressions;

public class MenuHierarchyMapper {

	public static QBean<MenuHierarchy> map(QMenu qMenu) {
		
		QWebResource resource = QWebResource.webResource;
		
		
		
		Expression<String> appIcon = new CaseBuilder()
				.when(qMenu.appIcon.appIconType.eq("RESOURCE")).then(
						JPAExpressions.select(resource.url).from(resource).where(resource.id.eq(qMenu.appIcon.appIcon))
						)
				.otherwise(qMenu.appIcon.appIcon).as("appIcon");
		
		return Projections.fields(MenuHierarchy.class,
				qMenu.id.menuGroupId.companyCode,
				qMenu.id.menuGroupId.menuGroupCode,
				qMenu.id.menuCode,
				qMenu.name.as("menuName"),
				qMenu.type.as("menuType"),
				qMenu.appUrl,
				qMenu.appIcon.appIconType.as("appIconType"),
				appIcon,
				//qMenu.appIcon.appIcon,
				qMenu.sequence,
				qMenu.level,						
				qMenu.parentMenuCode
				);
	}
	
}
