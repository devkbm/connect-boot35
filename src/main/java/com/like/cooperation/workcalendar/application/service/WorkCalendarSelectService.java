package com.like.cooperation.workcalendar.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.workcalendar.application.port.in.calendar.select.WorkCalendarSelectDTO;
import com.like.cooperation.workcalendar.application.port.in.calendar.select.WorkCalendarSelectUseCase;
import com.like.cooperation.workcalendar.application.port.out.WorkCalendarCommandDbPort;

@Transactional
@Service
public class WorkCalendarSelectService implements WorkCalendarSelectUseCase {

	WorkCalendarCommandDbPort dbPort;
	
	WorkCalendarSelectService(WorkCalendarCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public WorkCalendarSelectDTO select(Long id) {
		return WorkCalendarSelectDTO.toDTO(this.dbPort.select(id));
	}

}
