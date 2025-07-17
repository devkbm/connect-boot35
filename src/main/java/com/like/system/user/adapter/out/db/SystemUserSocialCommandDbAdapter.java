package com.like.system.user.adapter.out.db;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.system.user.adapter.out.db.data.SystemUserSocialRepository;
import com.like.system.user.application.port.out.SystemUserSocialEmailCommandDbPort;
import com.like.system.user.domain.oauth2.SystemUserSocialEmail;
import com.like.system.user.domain.oauth2.SystemUserSocialEmailId;

@Repository
public class SystemUserSocialCommandDbAdapter implements SystemUserSocialEmailCommandDbPort {

	SystemUserSocialRepository repository;
	
	SystemUserSocialCommandDbAdapter(SystemUserSocialRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Optional<SystemUserSocialEmail> select(SystemUserSocialEmailId id) {
		return repository.findById(id);
	}

	@Override
	public void save(SystemUserSocialEmail entity) {
		repository.save(entity);
	}

	@Override
	public void delete(SystemUserSocialEmailId id) {
		repository.deleteById(id);
	}

}
