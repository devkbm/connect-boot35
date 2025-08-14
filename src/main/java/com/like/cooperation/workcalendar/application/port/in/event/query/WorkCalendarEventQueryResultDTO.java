package com.like.cooperation.workcalendar.application.port.in.event.query;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.like.cooperation.workcalendar.domain.WorkCalendar;
import com.like.cooperation.workcalendar.domain.WorkCalendarEvent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
@Builder
public record WorkCalendarEventQueryResultDTO(
		LocalDateTime createdDt,
		String createdBy,
		LocalDateTime modifiedDt,
		String modifiedBy,
		String workCalendarId,
		String id,
		String text,
		String color,		
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", timezone = "Asia/Seoul")
		LocalDateTime start,		
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", timezone = "Asia/Seoul")
		LocalDateTime end,
		Boolean allDay
		) {
	
	public static WorkCalendarEventQueryResultDTO toDTO(WorkCalendarEvent entity) {
		
		WorkCalendar workCalendar = entity.getWorkCalendar();
		
		WorkCalendarEventQueryResultDTO dto = WorkCalendarEventQueryResultDTO.builder()
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
*/

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkCalendarEventQueryResultDTO {
	LocalDateTime createdDt;
	String createdBy;
	LocalDateTime modifiedDt;
	String modifiedBy;
	String workCalendarId;
	String id;
	String text;
	String color;		
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", timezone = "Asia/Seoul")
	LocalDateTime start;		
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", timezone = "Asia/Seoul")
	LocalDateTime end;
	Boolean allDay;
		
	
	public static WorkCalendarEventQueryResultDTO toDTO(WorkCalendarEvent entity) {
		
		WorkCalendar workCalendar = entity.getWorkCalendar();
		
		WorkCalendarEventQueryResultDTO dto = WorkCalendarEventQueryResultDTO.builder()
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