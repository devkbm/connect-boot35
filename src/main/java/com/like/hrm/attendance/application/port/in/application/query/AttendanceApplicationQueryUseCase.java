package com.like.hrm.attendance.application.port.in.application.query;

import java.util.List;

public interface AttendanceApplicationQueryUseCase {

	List<AttendanceApplicationQueryResultDTO> select(String staffNo);
}
