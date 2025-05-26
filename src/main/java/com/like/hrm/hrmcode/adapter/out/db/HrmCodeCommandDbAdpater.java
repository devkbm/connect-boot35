package com.like.hrm.hrmcode.adapter.out.db;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.hrm.hrmcode.adapter.out.db.jpa.HrmCodeRepository;
import com.like.hrm.hrmcode.application.port.out.hrmcode.HrmCodeCommandDbPort;
import com.like.hrm.hrmcode.domain.HrmCode;
import com.like.hrm.hrmcode.domain.HrmCodeId;

@Repository
public class HrmCodeCommandDbAdpater implements HrmCodeCommandDbPort {

	HrmCodeRepository repository;
	
	HrmCodeCommandDbAdpater(HrmCodeRepository repository) {
		this.repository = repository;
	}
	 
	@Override
	public Optional<HrmCode> select(HrmCodeId id) {
		return this.repository.findById(id);
	}

	@Override
	public void save(HrmCode entity) {
		this.repository.save(entity);		
	}

	@Override
	public void delete(HrmCodeId id) {
		this.repository.deleteById(id);
	}

}
