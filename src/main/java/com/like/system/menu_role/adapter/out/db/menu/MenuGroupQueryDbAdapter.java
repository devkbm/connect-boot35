package com.like.system.menu_role.adapter.out.db.menu;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.menu_role.adapter.out.db.menu.data.MenuGroupJpaRepository;
import com.like.system.menu_role.application.port.in.menu.query.MenuGroupQueryDTO;
import com.like.system.menu_role.application.port.out.menu.MenuGroupQueryDbPort;
import com.like.system.menu_role.domain.menu.MenuGroup;

@Repository
public class MenuGroupQueryDbAdapter implements MenuGroupQueryDbPort {

	MenuGroupJpaRepository repository;
	
	MenuGroupQueryDbAdapter(MenuGroupJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<MenuGroup> selectList(MenuGroupQueryDTO dto) {		
		return this.repository.findAll(dto.getBooleanBuilder());
	}

}
