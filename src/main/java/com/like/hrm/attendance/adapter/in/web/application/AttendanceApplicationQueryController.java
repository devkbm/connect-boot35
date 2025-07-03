package com.like.hrm.attendance.adapter.in.web.application;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.attendance.application.port.in.application.query.AttendanceApplicationQueryResultDTO;
import com.like.hrm.attendance.application.port.in.application.query.AttendanceApplicationQueryUseCase;
import com.like.system.holiday.application.port.in.query.HolidayQueryUseCase;

@RestController
public class AttendanceApplicationQueryController {

	AttendanceApplicationQueryUseCase useCase;
	
	HolidayQueryUseCase holidayUtilService;
	
	AttendanceApplicationQueryController(AttendanceApplicationQueryUseCase useCase, HolidayQueryUseCase holidayUtilService) {
		this.useCase = useCase;
		
		this.holidayUtilService = holidayUtilService;
	}
	
	/*
	@GetMapping("/api/hrm/dutyapplication")
	public ResponseEntity<?> getDutyApplicationList(DutyApplicationDTO.Search dto) {
											
		List<AttendanceApplicationQueryResultDTO> list = useCase.select(dto.staffId());
		
		return toList(list, MessageUtil.getQueryMessage(list.size()));
	}
	
	@GetMapping("/api/hrm/dutyapplication/period/{from}/{to}")
	public ResponseEntity<?> getDutyApplicationPeriod(@PathVariable @DateTimeFormat(pattern="yyyyMMdd")LocalDate from
													 ,@PathVariable @DateTimeFormat(pattern="yyyyMMdd")LocalDate to
													 ,@RequestParam String companyCode ) {
						
		List<DutyApplicationDTO.DutyDate> list = DutyApplicationDTO.DutyDate.convertInitDutyDateList(holidayUtilService.select(companyCode, from, to));			
		
		return toList(list, MessageUtil.getQueryMessage(list.size()));
	}
	*/
}
