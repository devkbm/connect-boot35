package com.like.system.menu_role.adapter.out.db.menu;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.system.menu_role.adapter.out.db.menu.data.MenuGroupJpaRepository;
import com.like.system.menu_role.adapter.out.db.menu.data.MenuJpaRepository;
import com.like.system.menu_role.application.port.out.menu.MenuCommandDbPort;
import com.like.system.menu_role.domain.menu.Menu;
import com.like.system.menu_role.domain.menu.MenuId;

@Repository
public class MenuDbAdapter implements MenuCommandDbPort {
	
	MenuJpaRepository repository;
	MenuGroupJpaRepository menuGroupRepository;
	
	MenuDbAdapter(
			MenuJpaRepository repository,
			MenuGroupJpaRepository menuGroupRepository
			) {
		this.repository = repository;
		this.menuGroupRepository = menuGroupRepository;
	}

	@Override
	public Optional<Menu> select(String companyCode, String menuGroupCode, String menuCode) {		
						
		return this.repository.findById(new MenuId(companyCode, menuGroupCode, menuCode));
	}
	
	@Override
	public void save(Menu entity) {		
		this.repository.save(entity);
	}

	@Override
	public void delete(String companyCode, String menuGroupCode, String menuCode) {
		this.repository.deleteById(new MenuId(companyCode, menuGroupCode, menuCode));		
	}
	
}
