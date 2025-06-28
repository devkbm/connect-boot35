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
	public boolean exist(MenuId id) {
		// new MenuId(companyCode, menuGroupCode, menuCode)
		return this.repository.existsById(id);
	}

	@Override
	public Optional<Menu> select(MenuId id) {							
		return this.repository.findById(id);
	}
	
	@Override
	public void save(Menu entity) {		
		this.repository.save(entity);
	}

	@Override
	public void delete(MenuId id) {
		this.repository.deleteById(id);		
	}
	
}
