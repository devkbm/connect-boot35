package com.like.hrm.staff.adapter.out.db.staff;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.hrm.staff.adapter.out.db.staff.data.StaffFamilyJpaRepository;
import com.like.hrm.staff.application.port.out.staff.StaffFamilyCommandDbPort;
import com.like.hrm.staff.domain.staff.family.StaffFamily;
import com.like.hrm.staff.domain.staff.family.StaffFamilyId;

@Repository
public class StaffFamilyCommandDbAdapter implements StaffFamilyCommandDbPort {

	StaffFamilyJpaRepository repository;
	
	StaffFamilyCommandDbAdapter(StaffFamilyJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Optional<StaffFamily> select(StaffFamilyId id) {		
		return this.repository.findById(id);
	}

	@Override
	public void save(StaffFamily entity) {
		this.repository.save(entity);
	}

	@Override
	public void delete(StaffFamilyId id) {
		this.repository.deleteById(id);
	}

}
