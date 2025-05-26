package com.like.hrm.staff.adapter.out.db.staff;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.hrm.staff.adapter.out.db.staff.data.StaffPeriodJpaRepository;
import com.like.hrm.staff.application.port.out.staff.StaffPeriodCommandDbPort;
import com.like.hrm.staff.domain.staff.period.StaffPeriod;
import com.like.hrm.staff.domain.staff.period.StaffPeriodId;

@Repository
public class StaffPeriodCommandDbAdapter implements StaffPeriodCommandDbPort {

	StaffPeriodJpaRepository repository;
	
	StaffPeriodCommandDbAdapter(StaffPeriodJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Optional<StaffPeriod> select(StaffPeriodId id) {	
		return this.repository.findById(id);
	}

	@Override
	public void save(StaffPeriod entity) {
		this.repository.save(entity);
	}

	@Override
	public void delete(StaffPeriodId id) {
		this.repository.deleteById(id);
	}

}
