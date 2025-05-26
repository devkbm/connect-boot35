package com.like.hrm.attendance.application.service.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.attendance.application.dto.application.AttendanceApplicationFormDTO;
import com.like.hrm.attendance.application.dto.application.AttendanceApplicationFormDTOMapper;
import com.like.hrm.attendance.application.port.in.application.AttendanceApplicationFormSaveUseCase;
import com.like.hrm.attendance.application.port.out.application.AttendanceApplicationFormCommandDbPort;
import com.like.hrm.attendance.domain.application.AttendanceApplication;

@Transactional
@Service
public class AttendanceApplicationFormSaveService implements AttendanceApplicationFormSaveUseCase {

	AttendanceApplicationFormCommandDbPort dbPort;
	
	AttendanceApplicationFormSaveService(AttendanceApplicationFormCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void save(AttendanceApplicationFormDTO dto) {
		AttendanceApplication entity = null;
		
		if (dto.dutyId() == null) {
			entity = AttendanceApplicationFormDTOMapper.newEntity(dto);
		} else {
			entity = this.dbPort.select(dto.dutyId()).orElse(null);
			
			AttendanceApplicationFormDTOMapper.modify(entity, dto);			
		}
		
		dbPort.save(entity);		
	}

}
