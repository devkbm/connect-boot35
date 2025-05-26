package com.like.hrm.staff.adapter.out.db.staff;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.hrm.staff.adapter.out.db.staff.data.StaffLicenseJpaRepository;
import com.like.hrm.staff.application.port.out.staff.StaffLicenseCommandDbPort;
import com.like.hrm.staff.domain.staff.license.StaffLicense;
import com.like.hrm.staff.domain.staff.license.StaffLicenseId;

@Repository
public class StaffLicenseCommandDbAdapter implements StaffLicenseCommandDbPort {

	StaffLicenseJpaRepository repository;
	
	StaffLicenseCommandDbAdapter(StaffLicenseJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Optional<StaffLicense> select(StaffLicenseId id) {
		return this.repository.findById(id);
	}

	@Override
	public void save(StaffLicense entity) {
		this.repository.save(entity);
	}

	@Override
	public void delete(StaffLicenseId id) {
		this.repository.deleteById(id);
	}

}
