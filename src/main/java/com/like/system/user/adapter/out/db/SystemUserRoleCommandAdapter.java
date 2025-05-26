package com.like.system.user.adapter.out.db;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.menu_role.adapter.out.db.role.jpa.RoleJpaEntity;
import com.like.system.menu_role.adapter.out.db.role.jpa.RoleJpaEntityId;
import com.like.system.menu_role.adapter.out.db.role.jpa.RoleJpaRepository;
import com.like.system.user.adapter.out.db.data.SystemUserRoleRepository;
import com.like.system.user.application.port.out.SystemUserRoleCommandDbPort;
import com.like.system.user.domain.SystemUserCompanyRole;

@Repository
public class SystemUserRoleCommandAdapter implements SystemUserRoleCommandDbPort {

	SystemUserRoleRepository repository;
	RoleJpaRepository roleRepository;
	
	SystemUserRoleCommandAdapter(SystemUserRoleRepository repository,
							  RoleJpaRepository roleRepository) {
		this.repository = repository;
		this.roleRepository = roleRepository;
	}
	
	@Override
	public List<RoleJpaEntity> select(String companyCode, List<String> roles) {
		if (roles == null) return new ArrayList<>();
		
		return roleRepository.findAllById(roles.stream()
				   			 				   .map(r -> new RoleJpaEntityId(companyCode, r))
				   			 				   .toList());
	}

	@Override
	public void save(List<SystemUserCompanyRole> roleList) {
		repository.saveAll(roleList);
	}

	@Override
	public void delete(List<SystemUserCompanyRole> roleList) {
		repository.deleteAll(roleList);		
	}
	
}
