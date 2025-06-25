package com.like.hrm.attendance.adapter.out.db.application;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.hrm.attendance.adapter.out.db.application.data.AttendanceApplicationRepository;
import com.like.hrm.attendance.application.port.out.application.AttendanceApplicationFormCommandDbPort;
import com.like.hrm.attendance.domain.application.AttendanceApplication;

@Repository
public class AttendanceApplicationCommandDbAdapter implements AttendanceApplicationFormCommandDbPort {

	AttendanceApplicationRepository repository;
	
	AttendanceApplicationCommandDbAdapter(AttendanceApplicationRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Optional<AttendanceApplication> select(Long id) {
		return repository.findById(id);
	}

	@Override
	public void save(AttendanceApplication entity) {
		repository.save(entity);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
