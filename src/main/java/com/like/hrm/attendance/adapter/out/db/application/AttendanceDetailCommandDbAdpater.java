package com.like.hrm.attendance.adapter.out.db.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.hrm.attendance.adapter.out.db.application.data.AttendanceDetailJpaRepository;
import com.like.hrm.attendance.application.port.out.application.AttendanceDetailCommandDbPort;
import com.like.hrm.attendance.domain.application.AttendanceDetail;
import com.like.hrm.attendance.domain.application.QAttendanceDetail;

@Repository
public class AttendanceDetailCommandDbAdpater implements AttendanceDetailCommandDbPort {

	AttendanceDetailJpaRepository repository;
	
	AttendanceDetailCommandDbAdpater(AttendanceDetailJpaRepository repository) { 
		this.repository = repository;
	}
	
	@Override
	public Optional<AttendanceDetail> select(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public void save(AttendanceDetail entity) {
		this.repository.save(entity);		
	}

	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);		
	}

	@Override
	public List<AttendanceDetail> selectByAppId(Long appId) {
		QAttendanceDetail qAttendanceDetail = QAttendanceDetail.attendanceDetail;
		
		return this.repository.findAll(qAttendanceDetail.attendanceApplication.appId.eq(appId));
	}

	@Override
	public void save(List<AttendanceDetail> entity) {
		this.repository.saveAll(entity);		
	}

}
