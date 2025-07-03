package com.like.hrm.attendance.application.port.out.application;

import java.util.List;

import com.like.hrm.attendance.application.port.in.application.query.AttendanceApplicationQueryResultDTO;

public interface AttendanceApplicationQueryDbPort {

	List<AttendanceApplicationQueryResultDTO> select(String staffNo);
}
