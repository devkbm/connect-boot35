package com.like.hrm.staff.adapter.out.db.staff;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.hrm.staff.adapter.out.db.staff.data.StaffSchoolCareerJpaRepository;
import com.like.hrm.staff.application.port.out.staff.StaffSchoolCareerCommandDbPort;
import com.like.hrm.staff.domain.staff.schoolcareer.StaffSchoolCareer;
import com.like.hrm.staff.domain.staff.schoolcareer.StaffSchoolCareerId;

@Repository
public class StaffSchoolCareerCommandDbAdapter implements StaffSchoolCareerCommandDbPort {

	StaffSchoolCareerJpaRepository repository;
	
	StaffSchoolCareerCommandDbAdapter(StaffSchoolCareerJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Optional<StaffSchoolCareer> select(StaffSchoolCareerId id) {
		return this.repository.findById(id);
	}

	@Override
	public void save(StaffSchoolCareer entity) {
		this.repository.save(entity);
	}

	@Override
	public void delete(StaffSchoolCareerId id) {
		this.repository.deleteById(id);
	}

}
