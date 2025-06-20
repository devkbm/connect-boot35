package com.like.hrm.attendance.application.dto.application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.like.common.vo.LocalDatePeriod;
import com.like.hrm.attendance.application.dto.application.AttendanceApplicationFormDTO.DutyDate;
import com.like.hrm.attendance.domain.application.AttendanceApplication;
import com.like.system.holiday.application.port.in.DateInfoSelectUseCase;
import com.like.system.holiday.domain.HolidayInfo;
import com.like.system.holiday.domain.HolidayInfoCollection;

public class AttendanceApplicationFormDTOMapper {

	public static AttendanceApplication newEntity(AttendanceApplicationFormDTO dto) {
		/*
		AttendanceApplication entity = new AttendanceApplication(
				dto.companyCode(),								  
		        dto.staffNo(),
		        dto.dutyCode(),
		        dto.dutyReason(),
		        new LocalDatePeriod(dto.fromDate(), dto.toDate()),
		        dto.selectedDate().stream().map(e -> e.date()).toList(),
		        dto.dutyTime()
		        );

		entity.setAppUrl(dto.clientAppUrl());

		return entity;
				*/
		return null;
	}
	
	public static void modify(AttendanceApplication entity, AttendanceApplicationFormDTO dto) {
		/*
		entity.modify(
				dto.dutyCode(),
				dto.dutyReason(),
				new LocalDatePeriod(dto.fromDate(), dto.toDate()),
				dto.selectedDate().stream().map(e -> e.date()).toList(),
				dto.dutyTime()
				);		
		*/
		
		entity.setAppUrl(dto.clientAppUrl());
	}
		
	
	public static AttendanceApplicationFormDTO toDTO(AttendanceApplication e, DateInfoSelectUseCase service) {
		if ( e == null ) return null;
		
		HolidayInfoCollection dateInfoList = service.select("001", e.getPeriod().getFrom(), e.getPeriod().getTo());
	
		return AttendanceApplicationFormDTO.builder()
				   .dutyId(e.getId())				   
				   .staffNo(e.getStaffNo())
				   .dutyCode(e.getDutyCode())
				   .dutyReason(e.getDutyReason())
				   .fromDate(e.getPeriod().getFrom())
				   .toDate(e.getPeriod().getTo())
				   .selectedDate(AttendanceApplicationFormDTOMapper.convertDutyDate(e, dateInfoList))				   
				   .build();	
	}
	
	
	private static List<DutyDate> convertDutyDate(AttendanceApplication entity, HolidayInfoCollection dateInfoList) {
		List<DutyDate> dutyDatelist = new ArrayList<>(dateInfoList.size());
		//List<LocalDate> selectedDate = entity.getSelectedDate();					
		
		/*
		for (HolidayInfo date : dateInfoList.getDates()) {							
			dutyDatelist.add(new DutyDate(date.getDate()										
										 ,selectedDate.contains(date.getDate())											 
										 ,date.isHoliday()
										 ,date.isHoliday()
										 ,date.isSunday()));
		}
		*/
		
		
		return dutyDatelist;
	}
}
