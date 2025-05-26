package com.like.system.holiday.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HolidayInfoCollection {

	private Map<LocalDate, HolidayInfo> dates;
	
	public HolidayInfoCollection(List<HolidayInfo> dates) {
		this.dates = dates.stream().collect(Collectors.toMap(HolidayInfo::getDate, dateInfo -> dateInfo));
	}
	
	public HolidayInfoCollection(List<HolidayInfo> dates, List<Holiday> holidayList) {
		this.dates = dates.stream().collect(Collectors.toMap(HolidayInfo::getDate, dateInfo -> dateInfo));
		this.setHolidayList(holidayList);
	}
	
	public HolidayInfo getDate(LocalDate date) {												
		return this.dates.get(date);
	}
	
	public List<HolidayInfo> getDates() {	
		List<HolidayInfo> list = new ArrayList<>(this.dates.values());
		Collections.sort(list, (e1, e2) -> e1.getDate().compareTo(e2.getDate()));
		return list;
	}
		
	public int size() {
		return this.dates.size();
	}
	
	private void setHolidayList(List<Holiday> holidayList) {
		for (Holiday holiday: holidayList) {								
			this.dates.get(holiday.getId().getDate()).setHoliday(holiday);
		}
	}	
}
