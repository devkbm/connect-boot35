package com.like.hrm.attendance.application.service.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.attendance.application.dto.application.AttendanceApplicationQueryResultDTO;
import com.like.hrm.attendance.application.port.in.application.AttendanceApplicationQueryUseCase;
import com.like.hrm.attendance.application.port.out.application.AttendanceApplicationQueryDbPort;

@Transactional(readOnly = true)
@Service
public class AttendanceApplicationQueryService implements AttendanceApplicationQueryUseCase {

	AttendanceApplicationQueryDbPort dbPort;
	
	AttendanceApplicationQueryService(AttendanceApplicationQueryDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public List<AttendanceApplicationQueryResultDTO> select(String staffNo) {
		return dbPort.select(staffNo);
	}

}
