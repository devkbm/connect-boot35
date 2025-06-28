package com.like.system.menu_role.adapter.out.db.role;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.menu_role.adapter.out.db.role.jpa.RoleEntityMapper;
import com.like.system.menu_role.adapter.out.db.role.jpa.RoleJpaEntity;
import com.like.system.menu_role.adapter.out.db.role.jpa.RoleJpaEntityId;
import com.like.system.menu_role.adapter.out.db.role.jpa.RoleJpaRepository;
import com.like.system.menu_role.application.port.out.role.RoleCommandDbPort;
import com.like.system.menu_role.domain.role.Role;

@Repository
@Transactional
public class RoleCommandDbAdapter implements RoleCommandDbPort {

	RoleJpaRepository jpaRepository;
	
	public RoleCommandDbAdapter(RoleJpaRepository jpaRepository) {
		this.jpaRepository = jpaRepository;
	}
	
	@Override
	public boolean exists(String companyCode, String roleCode) {
		return this.jpaRepository.existsById(new RoleJpaEntityId(companyCode, roleCode));
	}

	@Override
	public Optional<Role> find(String companyCode, String roleCode) {
		RoleJpaEntity entity = this.jpaRepository.findById(new RoleJpaEntityId(companyCode, roleCode)).orElse(null);
		
		//return RoleJpaEntityMapper.toEntity(entity);
		return Optional.ofNullable(RoleEntityMapper.INSTANCE.toEntity(entity));
	}

	@Override
	public void save(Role role) {
		//this.jpaRepository.save(RoleJpaEntityMapper.toJpaEntity(role));		
		this.jpaRepository.save(RoleEntityMapper.INSTANCE.toJpaEntity(role));
	}
	
	@Override
	public void delete(String companyCode, String roleCode) {
		this.jpaRepository.deleteById(new RoleJpaEntityId(companyCode, roleCode));		
	}

	
}
