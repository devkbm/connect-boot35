package com.like.cooperation.workcalendar.application.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.workcalendar.application.port.in.event.query.WorkCalendarEventQueryDTO;
import com.like.cooperation.workcalendar.application.port.in.event.query.WorkCalendarEventQueryResultDTO;
import com.like.cooperation.workcalendar.application.port.in.event.query.WorkCalendarEventQueryUseCase;
import com.like.cooperation.workcalendar.application.port.out.WorkCalendarEventQueryDbPort;

@Transactional(readOnly=true)
@Service
public class WorkCalendarEventQueryService implements WorkCalendarEventQueryUseCase {

	WorkCalendarEventQueryDbPort dbPort;
	
	public WorkCalendarEventQueryService(WorkCalendarEventQueryDbPort dbPort) {
		this.dbPort = dbPort;
	}

	@Override
	public List<WorkCalendarEventQueryResultDTO> getScheduleList(WorkCalendarEventQueryDTO searchCondition) {
		/*
		return this.dbPort.getScheduleList(searchCondition)
						  .stream()
						  .map(e -> WorkCalendarEventQueryResultDTO.toDTO(e))
						  .toList();
		*/
		
		return this.dbPort.getScheduleList2(searchCondition);
	}	
}
