package com.like.hrm.attendance.application.service.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.attendance.application.port.in.application.save.AttendanceApplicationSaveDTO;
import com.like.hrm.attendance.application.port.in.application.save.AttendanceApplicationSaveDTOMapper;
import com.like.hrm.attendance.application.port.in.application.save.AttendanceApplicationSaveUseCase;
import com.like.hrm.attendance.application.port.out.application.AttendanceApplicationFormCommandDbPort;
import com.like.hrm.attendance.domain.application.AttendanceApplication;
import com.like.hrm.attendance.domain.application.AttendanceDetail;

@Transactional
@Service
public class AttendanceApplicationSaveService implements AttendanceApplicationSaveUseCase {

	AttendanceApplicationFormCommandDbPort dbPort;
	
	AttendanceApplicationSaveService(AttendanceApplicationFormCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void save(AttendanceApplicationSaveDTO dto) {
		AttendanceApplication entity = null;
		AttendanceDetail details = null;
		
		if (dto.dutyId() == null) {
			entity = AttendanceApplicationSaveDTOMapper.newEntity(dto);
		} else {
			entity = this.dbPort.select(dto.dutyId()).orElse(null);
			
			AttendanceApplicationSaveDTOMapper.modify(entity, dto);			
		}
		
		dbPort.save(entity);		
	}

}
