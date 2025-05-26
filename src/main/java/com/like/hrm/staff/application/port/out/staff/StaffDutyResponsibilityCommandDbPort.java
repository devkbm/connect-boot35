package com.like.hrm.staff.application.port.out.staff;

import java.util.Optional;

import com.like.hrm.staff.domain.staff.dutyresponsibility.StaffDuty;
import com.like.hrm.staff.domain.staff.dutyresponsibility.StaffDutyId;

public interface StaffDutyResponsibilityCommandDbPort {

	Optional<StaffDuty> select(StaffDutyId id);	

	void save(StaffDuty entity);
	
	void delete(StaffDutyId id);
}
