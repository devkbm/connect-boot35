package com.like.cooperation.workcalendar.application.port.out;

import java.util.List;

import com.like.cooperation.workcalendar.application.port.in.calendar.query.WorkCalendarQueryDTO;
import com.like.cooperation.workcalendar.application.port.in.calendar.query.WorkCalendarQueryResultDTO;

public interface WorkCalendarQueryDbPort {
	public List<WorkCalendarQueryResultDTO> getWorkGroupList(WorkCalendarQueryDTO searchCondition);
	
	public List<WorkCalendarQueryResultDTO> getWorkGroupList(String userId);
}
