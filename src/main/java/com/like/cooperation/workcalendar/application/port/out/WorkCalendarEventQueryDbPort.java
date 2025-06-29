package com.like.cooperation.workcalendar.application.port.out;

import java.util.List;

import com.like.cooperation.workcalendar.application.port.in.event.query.WorkCalendarEventQueryDTO;
import com.like.cooperation.workcalendar.domain.WorkCalendarEvent;

public interface WorkCalendarEventQueryDbPort {

	List<WorkCalendarEvent> getScheduleList(WorkCalendarEventQueryDTO searchCondition);
}
