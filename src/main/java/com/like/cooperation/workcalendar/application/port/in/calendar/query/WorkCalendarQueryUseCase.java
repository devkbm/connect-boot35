package com.like.cooperation.workcalendar.application.port.in.calendar.query;

import java.util.List;

public interface WorkCalendarQueryUseCase {

	public List<WorkCalendarQueryResultDTO> getWorkGroupList(WorkCalendarQueryDTO searchCondition);
	
	public List<WorkCalendarQueryResultDTO> getWorkGroupList(String userId);
}
