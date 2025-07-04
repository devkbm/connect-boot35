package com.like.cooperation.workcalendar.application.port.in.event.select;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.like.cooperation.workcalendar.domain.WorkCalendar;
import com.like.cooperation.workcalendar.domain.WorkCalendarEvent;

import lombok.Builder;

@Builder
public record WorkCalendarEventResponseDTO(
		LocalDateTime createdDt,
		String createdBy,
		LocalDateTime modifiedDt,
		String modifiedBy,
		String workCalendarId,
		String id,
		String text,
		String color,
		//@DateTimeFormat(pattern="E MMM dd yyyy HH:mm:ss 'GMT'Z")
		//@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", timezone = "Asia/Seoul")
		LocalDateTime start,
		//@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", timezone = "Asia/Seoul")
		LocalDateTime end,
		Boolean allDay
		) {
	
	public static WorkCalendarEventResponseDTO toDTO
	(WorkCalendarEvent entity) {
		
		WorkCalendar workCalendar = entity.getWorkCalendar();
		
		WorkCalendarEventResponseDTO dto = WorkCalendarEventResponseDTO.builder()
							   .workCalendarId(workCalendar.getId().toString())
							   .id(entity.getId().toString())
							   .text(entity.getTitle())
							   .color(workCalendar.getColor())
							   .start(entity.getStart())
							   .end(entity.getEnd())
							   .allDay(entity.getAllDay())																							
							   .build();
																
		return dto;
	}
}