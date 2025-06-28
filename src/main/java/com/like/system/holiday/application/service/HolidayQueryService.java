package com.like.system.holiday.application.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.like.system.holiday.domain.HolidayInfo;
import com.like.system.holiday.domain.HolidayInfoCollection;
import com.like.system.holiday.application.port.in.query.HolidayQueryUseCase;
import com.like.system.holiday.application.port.out.HolidayQueryDbPort;
import com.like.system.holiday.domain.Holiday;

@Service
public class HolidayQueryService implements HolidayQueryUseCase {

	HolidayQueryDbPort port;
	
	public HolidayQueryService(HolidayQueryDbPort port) {
		this.port = port;
	}
	
	@Override
	public HolidayInfoCollection select(String companyCode, LocalDate fromDate, LocalDate toDate) {
		List<HolidayInfo> days = this.createDateInfoList(fromDate, toDate);
		
		List<Holiday> holidays = this.getHolidayList(companyCode, fromDate, toDate);
		
		return new HolidayInfoCollection(days, holidays);
	}
	
	private List<HolidayInfo> createDateInfoList(LocalDate fromDate, LocalDate toDate) {
		if (fromDate.isAfter(toDate)) 
			throw new IllegalArgumentException("종료일자보다 시작일자가 큽니다.");
		
		final long dayCnt = fromDate.until(toDate, ChronoUnit.DAYS);
		List<HolidayInfo> list = new ArrayList<>(Math.toIntExact(dayCnt));			
		
		while (fromDate.isBefore(toDate) || fromDate.isEqual(toDate)) {
			list.add(new HolidayInfo(fromDate));			
			fromDate = fromDate.plusDays(1);
		}
		
		return list;
	}
	
	private List<Holiday> getHolidayList(String companyCode, LocalDate fromDate, LocalDate toDate) {
		return port.selectList(companyCode, fromDate, toDate);
	}

}
