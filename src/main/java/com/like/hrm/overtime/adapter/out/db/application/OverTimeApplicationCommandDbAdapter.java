package com.like.hrm.overtime.adapter.out.db.application;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.hrm.overtime.adapter.out.db.application.data.OverTimeApplicationRepository;
import com.like.hrm.overtime.domain.application.OverTimeApplication;
import com.like.hrm.overtime.domain.application.port.out.OverTimeApplicationCommandDbPort;

@Repository
public class OverTimeApplicationCommandDbAdapter implements OverTimeApplicationCommandDbPort {

	OverTimeApplicationRepository repository;
		
	OverTimeApplicationCommandDbAdapter(OverTimeApplicationRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Optional<OverTimeApplication> select(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public void save(OverTimeApplication entity) {
		this.repository.save(entity);		
	}

	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);		
	}

}
