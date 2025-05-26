package com.like.cooperation.workcalendar.application.port.in;

import com.like.cooperation.workcalendar.application.dto.WorkCalendarSaveDTO;

public interface WorkCalendarSelectUseCase {

	WorkCalendarSaveDTO select(Long id);
}
