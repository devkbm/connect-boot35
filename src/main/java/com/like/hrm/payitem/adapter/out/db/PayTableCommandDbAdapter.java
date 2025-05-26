package com.like.hrm.payitem.adapter.out.db;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.hrm.payitem.adapter.out.db.data.PayTableJpaRepository;
import com.like.hrm.payitem.application.port.out.PayTableCommandDbPort;
import com.like.hrm.payitem.domain.PayTable;

@Repository
public class PayTableCommandDbAdapter implements PayTableCommandDbPort {

	PayTableJpaRepository repository;
	
	PayTableCommandDbAdapter(PayTableJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Optional<PayTable> select(String id) {
		return this.repository.findById(id);
	}

	@Override
	public void save(PayTable entity) {
		this.repository.save(entity);		
	}

	@Override
	public void delete(String id) {
		this.repository.deleteById(id);
	}

}
