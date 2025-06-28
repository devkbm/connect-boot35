package com.like.system.menu_role.adapter.out.db.menu;

import static org.springframework.util.StringUtils.hasText;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.menu_role.adapter.out.db.menu.data.MenuJpaRepository;
import com.like.system.menu_role.application.port.in.menu.query.MenuQueryDTO;
import com.like.system.menu_role.application.port.out.menu.MenuQueryDbPort;
import com.like.system.menu_role.domain.menu.Menu;
import com.like.system.menu_role.domain.menu.QMenu;
import com.like.system.menu_role.domain.menu.QMenuGroup;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

@Repository
public class MenuQueryDbAdapter implements MenuQueryDbPort {

	MenuJpaRepository repository;	
	
	private static final QMenu qType = QMenu.menu;
	
	MenuQueryDbAdapter(MenuJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<Menu> selectList(MenuQueryDTO dto) {		
		return this.repository.findAll(getBooleanBuilder(dto));							  
	}
	
	
	private BooleanBuilder getBooleanBuilder(MenuQueryDTO dto) {																
		return new BooleanBuilder()
				.and(equalOrganizationCode(dto.companyCode()))
				.and(equalMenuGroupCode(dto.menuGroupCode()))
	//			.and(likeMenuId(this.menuId))
				.and(likeMenuName(dto.menuName()));
	}

	private BooleanExpression equalOrganizationCode(String companyCode) {					
		return QMenuGroup.menuGroup.id.companyCode.eq(companyCode);
	}
	
	private BooleanExpression equalMenuGroupCode(String menuGroupCode) {					
		return QMenuGroup.menuGroup.id.menuGroupCode.eq(menuGroupCode);
	}
	/*
	private BooleanExpression likeMenuId(String menuId) {
		return hasText(menuId) ? qType.id.like("%"+menuId+"%") : null;					
	}
	*/
	private BooleanExpression likeMenuName(String menuName) {
		return hasText(menuName) ? qType.name.like("%"+menuName+"%") : null;					
	}

}
