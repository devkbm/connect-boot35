package com.like.cooperation.workcalendar.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.like.cooperation.workcalendar.application.port.in.calendar.select.WorkCalendarSelectDTO;
import com.like.cooperation.workcalendar.application.port.in.calendar.select.WorkCalendarSelectUseCase;
import com.like.core.message.MessageUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class WorkCalendarSelectController {

	WorkCalendarSelectUseCase useCase;
	
	WorkCalendarSelectController(WorkCalendarSelectUseCase useCase) {
		this.useCase = useCase;
	}
	
	@GetMapping("/api/grw/workcalendar/{id}")
	public ResponseEntity<?> getWorkGroup(@PathVariable Long id) {																
		
		WorkCalendarSelectDTO dto = useCase.select(id);
		
		log.info(dto.toString());
		
		return toOne(dto, MessageUtil.getQueryMessage(dto == null ? 0 : 1));													
	}
}
