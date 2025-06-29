package com.like.cooperation.workcalendar.application.port.in.event.query;

import java.util.List;

public interface WorkCalendarEventQueryUseCase {

	public List<WorkCalendarEventQueryResultDTO> getScheduleList(WorkCalendarEventQueryDTO searchCondition);
}
