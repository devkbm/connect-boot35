package com.like.cooperation.workcalendar.application.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.workcalendar.application.port.in.calendar.query.WorkCalendarQueryDTO;
import com.like.cooperation.workcalendar.application.port.in.calendar.query.WorkCalendarQueryResultDTO;
import com.like.cooperation.workcalendar.application.port.in.calendar.query.WorkCalendarQueryUseCase;
import com.like.cooperation.workcalendar.application.port.out.WorkCalendarQueryDbPort;

@Transactional(readOnly=true)
@Service
public class WorkCalendarQueryService implements WorkCalendarQueryUseCase {
				
	WorkCalendarQueryDbPort dbPort;
	
	public WorkCalendarQueryService(WorkCalendarQueryDbPort dbPort) {		
		this.dbPort = dbPort;
	}

	@Override
	public List<WorkCalendarQueryResultDTO> getWorkGroupList(WorkCalendarQueryDTO searchCondition) {
		return this.dbPort.getWorkGroupList(searchCondition);
	}

	@Override
	public List<WorkCalendarQueryResultDTO> getWorkGroupList(String userId) {
		return this.dbPort.getWorkGroupList(userId);
	}	
}
