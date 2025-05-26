package com.like.hrm.payitem.adapter.out.db;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.hrm.payitem.adapter.out.db.data.PayItemJpaRepository;
import com.like.hrm.payitem.application.port.out.PayItemCommandDbPort;
import com.like.hrm.payitem.domain.PayItem;
import com.like.hrm.payitem.domain.PayItemId;

@Repository
public class PayItemCommandDbAdapter implements PayItemCommandDbPort {

	PayItemJpaRepository repository;
	
	PayItemCommandDbAdapter(PayItemJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Optional<PayItem> select(PayItemId id) {
		return this.repository.findById(id);
	}

	@Override
	public void save(PayItem entity) {
		this.repository.save(entity);
	}

	@Override
	public void delete(PayItemId id) {
		this.repository.deleteById(id);
	}

}
