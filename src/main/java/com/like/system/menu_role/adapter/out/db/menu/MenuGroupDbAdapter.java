package com.like.system.menu_role.adapter.out.db.menu;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.system.menu_role.adapter.out.db.menu.data.MenuGroupJpaRepository;
import com.like.system.menu_role.application.port.out.menu.MenuGroupCommandDbPort;
import com.like.system.menu_role.domain.menu.MenuGroup;
import com.like.system.menu_role.domain.menu.MenuGroupId;

@Repository
public class MenuGroupDbAdapter implements MenuGroupCommandDbPort {

	MenuGroupJpaRepository repository;
	
	MenuGroupDbAdapter(MenuGroupJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public boolean exist(MenuGroupId id) {
		// new MenuGroupId(companyCode, menuGroupCode)
		return this.repository.existsById(id);
	}

	@Override
	public Optional<MenuGroup> select(MenuGroupId id) {		
		
		return this.repository.findById(id); 
	}
	
	@Override
	public void save(MenuGroup entity) {
		this.repository.save(entity);		
	}

	@Override
	public void delete(MenuGroupId id) {
		this.repository.deleteById(id);		
	}
	
}
