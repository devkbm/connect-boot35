package com.like.system.user.adapter.out.db;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.system.user.adapter.out.db.data.SystemUserSocialRepository;
import com.like.system.user.application.port.out.SystemUserSocialCommandDbPort;
import com.like.system.user.domain.oauth2.SystemUserSocial;
import com.like.system.user.domain.oauth2.SystemUserSocialId;

@Repository
public class SystemUserSocialCommandDbAdapter implements SystemUserSocialCommandDbPort {

	SystemUserSocialRepository repository;
	
	SystemUserSocialCommandDbAdapter(SystemUserSocialRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Optional<SystemUserSocial> select(SystemUserSocialId id) {
		return repository.findById(id);
	}

	@Override
	public void save(SystemUserSocial entity) {
		repository.save(entity);
	}

	@Override
	public void delete(SystemUserSocialId id) {
		repository.deleteById(id);
	}

}
