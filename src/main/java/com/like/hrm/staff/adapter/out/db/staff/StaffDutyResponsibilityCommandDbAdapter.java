package com.like.hrm.staff.adapter.out.db.staff;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.hrm.staff.adapter.out.db.staff.data.StaffDutyResponsibilityJpaRepository;
import com.like.hrm.staff.application.port.out.staff.StaffDutyResponsibilityCommandDbPort;
import com.like.hrm.staff.domain.staff.dutyresponsibility.StaffDuty;
import com.like.hrm.staff.domain.staff.dutyresponsibility.StaffDutyId;

@Repository
public class StaffDutyResponsibilityCommandDbAdapter implements StaffDutyResponsibilityCommandDbPort {

	StaffDutyResponsibilityJpaRepository repository;
	
	StaffDutyResponsibilityCommandDbAdapter(StaffDutyResponsibilityJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Optional<StaffDuty> select(StaffDutyId id) {
		return this.repository.findById(id);
	}

	@Override
	public void save(StaffDuty entity) {
		this.repository.save(entity);
	}

	@Override
	public void delete(StaffDutyId id) {
		this.repository.deleteById(id);		
	}

}
