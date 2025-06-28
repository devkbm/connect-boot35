package com.like.system.holiday.adapter.out.db;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.system.holiday.adapter.out.db.data.HolidayJpaRepository;
import com.like.system.holiday.application.port.out.HolidayCommandDbPort;
import com.like.system.holiday.domain.Holiday;
import com.like.system.holiday.domain.HolidayId;

@Repository
public class HolidayCommandDbAdapter implements HolidayCommandDbPort {

	HolidayJpaRepository repository;
	
	HolidayCommandDbAdapter(HolidayJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Optional<Holiday> select(String companyCode, LocalDate date) {
		return this.repository.findById(new HolidayId(companyCode, date));
	}

	@Override
	public void save(Holiday entity) {
		this.repository.save(entity);		
	}

	@Override
	public void delete(String companyCode, LocalDate date) {
		this.repository.deleteById(new HolidayId(companyCode, date));		
	}

}
