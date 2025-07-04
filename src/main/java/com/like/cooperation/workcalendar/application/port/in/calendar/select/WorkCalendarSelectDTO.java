package com.like.cooperation.workcalendar.application.port.in.calendar.select;

import java.time.LocalDateTime;
import java.util.List;

import com.like.cooperation.workcalendar.domain.WorkCalendar;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
public record WorkCalendarSelectDTO(
		LocalDateTime createdDt,
		String createdBy,
		LocalDateTime modifiedDt,
		String modifiedBy,
		String clientAppUrl,
		String companyCode,
		String workCalendarId,
		@NotEmpty
		String workCalendarName,
		String color,
		List<String> memberList
		) {
	
	public WorkCalendar newWorkGroup() {
		WorkCalendar entity = new WorkCalendar(this.workCalendarName, this.color);
		entity.setAppUrl(clientAppUrl);
		return entity;
	}
	
	public void modifyWorkGroup(WorkCalendar workGroup) {
		workGroup.modifyEntity(this.workCalendarName, color);
		
		workGroup.setAppUrl(clientAppUrl);
	}
	
	public static WorkCalendarSelectDTO toDTO(WorkCalendar entity) {
		
		log.info(entity.toString());
		
		WorkCalendarSelectDTO dto = WorkCalendarSelectDTO.builder()
									   .workCalendarId(entity.getId().toString())
									   .workCalendarName(entity.getName())
									   .color(entity.getColor())
									   .memberList(entity.getMemberList().stream()
										  	 						     .map(r -> r.getUserId())
	 										 						     .toList())
									   .build();

		return dto;
	}
}