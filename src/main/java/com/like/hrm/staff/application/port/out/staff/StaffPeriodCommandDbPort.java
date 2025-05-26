package com.like.hrm.staff.application.port.out.staff;

import java.util.Optional;

import com.like.hrm.staff.domain.staff.period.StaffPeriod;
import com.like.hrm.staff.domain.staff.period.StaffPeriodId;

public interface StaffPeriodCommandDbPort {

	Optional<StaffPeriod> select(StaffPeriodId id);	

	void save(StaffPeriod entity);
	
	void delete(StaffPeriodId id);
}
