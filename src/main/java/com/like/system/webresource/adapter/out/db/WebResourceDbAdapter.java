package com.like.system.webresource.adapter.out.db;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.system.webresource.adapter.out.db.data.WebResourceJpaRepository;
import com.like.system.webresource.application.port.out.WebResourceCommandDbPort;
import com.like.system.webresource.domain.WebResource;

@Repository
public class WebResourceDbAdapter implements WebResourceCommandDbPort {

	WebResourceJpaRepository repository;
	
	WebResourceDbAdapter(WebResourceJpaRepository repository) {
		this.repository = repository;
	}
	 
	@Override
	public boolean exists(String id) {
		return this.repository.existsById(id);
	}
	
	@Override
	public Optional<WebResource> select(String id) {							
		return this.repository.findById(id);			
	}

	@Override
	public void save(WebResource entity) {
		this.repository.save(entity);		
	}

	@Override
	public void delete(String id) {
		this.repository.deleteById(id);
	}
	
}
