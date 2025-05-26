package com.like.hrm.attendance.application.port.in.application;

import java.util.List;

import com.like.hrm.attendance.application.dto.application.AttendanceApplicationQueryResultDTO;

public interface AttendanceApplicationQueryUseCase {

	List<AttendanceApplicationQueryResultDTO> select(String staffNo);
}
