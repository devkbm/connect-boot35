package com.like.hrm.attendance.application.service.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.attendance.application.dto.application.AttendanceApplicationDTO;
import com.like.hrm.attendance.application.dto.application.AttendanceApplicationDTOMapper;
import com.like.hrm.attendance.application.port.in.application.AttendanceApplicationFormSaveUseCase;
import com.like.hrm.attendance.application.port.out.application.AttendanceApplicationFormCommandDbPort;
import com.like.hrm.attendance.domain.application.AttendanceApplication;
import com.like.hrm.attendance.domain.application.AttendanceDetail;

@Transactional
@Service
public class AttendanceApplicationSaveService implements AttendanceApplicationFormSaveUseCase {

	AttendanceApplicationFormCommandDbPort dbPort;
	
	AttendanceApplicationSaveService(AttendanceApplicationFormCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void save(AttendanceApplicationDTO dto) {
		AttendanceApplication entity = null;
		AttendanceDetail details = null;
		
		if (dto.dutyId() == null) {
			entity = AttendanceApplicationDTOMapper.newEntity(dto);
		} else {
			entity = this.dbPort.select(dto.dutyId()).orElse(null);
			
			AttendanceApplicationDTOMapper.modify(entity, dto);			
		}
		
		dbPort.save(entity);		
	}

}
