package com.like.system.holiday.adapter.out.db;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.holiday.adapter.out.db.data.HolidayJpaRepository;
import com.like.system.holiday.application.port.out.HolidayQueryDbPort;
import com.like.system.holiday.domain.Holiday;
import com.like.system.holiday.domain.QHoliday;
import com.querydsl.core.types.Predicate;

@Repository
public class HolidayQueryDbAdapter implements HolidayQueryDbPort {

	HolidayJpaRepository repository;
	
	HolidayQueryDbAdapter(HolidayJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<Holiday> selectList(String companyCode, LocalDate fromDate, LocalDate toDate) {
		QHoliday qHoliday = QHoliday.holiday;
		Predicate predicate = qHoliday.id.companyCode.eq(companyCode)
						 .and(qHoliday.id.date.goe(fromDate).and(qHoliday.id.date.loe(toDate)));
				
		return this.repository.findAll(predicate);
	}

}
