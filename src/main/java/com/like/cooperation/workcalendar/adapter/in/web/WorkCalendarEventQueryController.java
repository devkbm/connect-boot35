package com.like.cooperation.workcalendar.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.like.cooperation.workcalendar.application.port.in.event.query.WorkCalendarEventQueryDTO;
import com.like.cooperation.workcalendar.application.port.in.event.query.WorkCalendarEventQueryResultDTO;
import com.like.cooperation.workcalendar.application.port.in.event.query.WorkCalendarEventQueryUseCase;
import com.like.core.message.MessageUtil;

@RestController
public class WorkCalendarEventQueryController {

	private WorkCalendarEventQueryUseCase service;
	
	public WorkCalendarEventQueryController(WorkCalendarEventQueryUseCase service) {
		this.service = service;
	}
	
	@GetMapping("/api/grw/workcalendarevent")
	public ResponseEntity<?> getScheduleList(@ModelAttribute WorkCalendarEventQueryDTO searchCondition) {										
		
		List<WorkCalendarEventQueryResultDTO> list = service.getScheduleList(searchCondition);
		
		return toList(list, MessageUtil.getQueryMessage(list.size()));												
	}
}
