package com.like.hrm.attendance.application.port.in.application.query;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AttendanceApplicationQueryResultDTO {

	Long id;	
	String staffNo;
	String staffName;
	String dutyCode;
	String dutyName;
	String dutyReason;
	LocalDate fromDate;
	LocalDate toDate;

}
