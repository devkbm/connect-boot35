package com.like.system.user.adapter.out.db;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.system.user.adapter.out.db.data.SystemUserRepository;
import com.like.system.user.application.port.out.SystemUserCommandDbPort;
import com.like.system.user.domain.SystemUser;
import com.like.system.user.domain.SystemUserId;


@Repository
public class SystemUserCommandDbAdapter implements SystemUserCommandDbPort {

	SystemUserRepository repository;	
	
	SystemUserCommandDbAdapter(SystemUserRepository repository) {
		this.repository = repository;			
	}
	
	@Override
	public boolean isExists(String userId) {	
		return this.repository.existsById(new SystemUserId(userId));
	}
	
	@Override
	public Optional<SystemUser> select(String userId) {		
		return this.repository.findById(new SystemUserId(userId));
	}
	
	@Override
	public void save(SystemUser entity) {
		this.repository.save(entity);		
	}
	
	@Override
	public void delete(String userId) {
		this.repository.deleteById(new SystemUserId(userId));		
	}

	@Override
	public List<SystemUser> select(List<String> userIds) {	
		return this.repository.findAllById(userIds.stream().map(e -> new SystemUserId(e)).toList());
	}	
			
}
