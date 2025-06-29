package com.like.cooperation.workcalendar.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.like.cooperation.workcalendar.application.port.in.calendar.query.WorkCalendarQueryDTO;
import com.like.cooperation.workcalendar.application.port.in.calendar.query.WorkCalendarQueryResultDTO;
import com.like.cooperation.workcalendar.application.port.in.calendar.query.WorkCalendarQueryUseCase;
import com.like.core.message.MessageUtil;
import com.like.core.util.SessionUtil;

@RestController
public class WorkCalendarQueryController {

	private WorkCalendarQueryUseCase useCase;
	
	public WorkCalendarQueryController(WorkCalendarQueryUseCase useCase) {
		this.useCase = useCase;		
	}
	
	@GetMapping("/api/grw/workcalendar")
	public ResponseEntity<?> getWorkGroupList(@ModelAttribute WorkCalendarQueryDTO searchCondition) {
						
		List<WorkCalendarQueryResultDTO> list = useCase.getWorkGroupList(searchCondition);				
		
		return toList(list, MessageUtil.getQueryMessage(list.size()));												
	}
	
	@GetMapping("/api/grw/myworkcalendar")
	public ResponseEntity<?> getWorkGroupList() {							
		
		List<WorkCalendarQueryResultDTO> list = useCase.getWorkGroupList(SessionUtil.getUserId());				
		
		return toList(list, MessageUtil.getQueryMessage(list.size()));												
	}
}
