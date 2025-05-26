package com.like.hrm.attendance.application.dto.application;

import static org.springframework.util.StringUtils.hasText;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.like.common.vo.LocalDatePeriod;
import com.like.hrm.attendance.domain.application.AttendanceApplication;
import com.like.hrm.attendance.domain.application.QAttendanceApplication;
import com.like.system.holiday.application.port.in.DateInfoSelectUseCase;
import com.like.system.holiday.domain.HolidayInfo;
import com.like.system.holiday.domain.HolidayInfoCollection;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DutyApplicationDTO {

	public record Search(
			String staffId
			) {
		private static QAttendanceApplication qDutyApplication = QAttendanceApplication.attendanceApplication;
		
		public BooleanBuilder getBooleanBuilder() {
			BooleanBuilder builder = new BooleanBuilder();
			
			builder
				.and(eqStaffId(this.staffId));
			
			return builder;
		}
		
		private BooleanExpression eqStaffId(String staffId) {
			return null;
			//return hasText(staffId) ? qDutyApplication.staffId.eq(staffId) : null;					
		}
	}	
		
	@Builder(access = AccessLevel.PRIVATE)
	public static record Form(
			String clientAppUrl,
			String companyCode,
			Long dutyId,
			String staffId,
			String dutyCode,
			String dutyReason,
			LocalDate fromDate,
			LocalDate toDate,
			List<DutyDate> selectedDate,
			BigDecimal dutyTime) {
		
		public static Form convert(AttendanceApplication e, DateInfoSelectUseCase service) {								
			HolidayInfoCollection dateInfoList = service.select("001", e.getPeriod().getFrom(), e.getPeriod().getTo());

			
			return Form.builder()
					   .dutyId(e.getId())
					   //.staffId(e.getStaffId())
					   .dutyCode(e.getDutyCode())
					   .dutyReason(e.getDutyReason())
					   .fromDate(e.getPeriod().getFrom())
					   .toDate(e.getPeriod().getTo())
					   .selectedDate(Form.convertDutyDate(e, dateInfoList))
					   .dutyTime(e.getSumDutyTime())
					   .build();								  									  									  									
		}
		
		public AttendanceApplication newEntity() {		
			
			/*
			WorkChangeApplication entity = new WorkChangeApplication(staffId								  
												        ,dutyCode
												        ,dutyReason
												        ,new LocalDatePeriod(fromDate, toDate)
												        ,this.getSelectedDate()
												        ,dutyTime);
			
			entity.setAppUrl(clientAppUrl);
			
			return entity;
			*/
			
			return null;
			
		}
		
		public void modifyEntity(AttendanceApplication entity) {
			entity.modify(dutyCode
							   ,dutyReason
							   ,new LocalDatePeriod(fromDate, toDate)
							   ,this.getSelectedDate()
							   ,dutyTime);		
			
			entity.setAppUrl(clientAppUrl);
		}			
		
		private List<LocalDate> getSelectedDate() {
			return selectedDate.stream().map(e -> e.date()).toList();
		}
		
		private static List<DutyDate> convertDutyDate(AttendanceApplication entity, HolidayInfoCollection dateInfoList) {
			List<DutyDate> dutyDatelist = new ArrayList<>(dateInfoList.size());
			List<LocalDate> selectedDate = entity.getSelectedDate();					
			
			for (HolidayInfo date : dateInfoList.getDates()) {							
				dutyDatelist.add(new DutyDate(date.getDate()										
											 ,selectedDate.contains(date.getDate())											 
											 ,date.isHoliday()
											 ,date.isSaturDay()
											 ,date.isSunday()));
			}
			
			log.info(dutyDatelist.toString());
			
			return dutyDatelist;
		}
	}		
	
	public record DutyDate(
			LocalDate date,
			@JsonProperty("isSelected")boolean isSelected,
			@JsonProperty("isHoliday")boolean isHoliday,
			@JsonProperty("isSaturday")boolean isSaturday,
			@JsonProperty("isSunday")boolean isSunday
			) {
		
		public static List<DutyDate> convertInitDutyDateList(HolidayInfoCollection dateInfoList) {
			List<DutyDate> dutyDatelist = new ArrayList<>(dateInfoList.size());
			
			for (HolidayInfo date : dateInfoList.getDates()) {								
				if (date.isWeekend() || date.isHoliday() ) {
					dutyDatelist.add(new DutyDate(date.getDate(), false, date.isHoliday(), date.isSaturDay(), date.isSunday()));
				} else {
					dutyDatelist.add(new DutyDate(date.getDate(), true, date.isHoliday(), date.isSaturDay(), date.isSunday()));
				}				
			}					
			
			return dutyDatelist;
		}
	}
	
}
