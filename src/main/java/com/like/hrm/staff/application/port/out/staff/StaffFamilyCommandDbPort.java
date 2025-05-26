package com.like.hrm.staff.application.port.out.staff;

import java.util.Optional;

import com.like.hrm.staff.domain.staff.family.StaffFamily;
import com.like.hrm.staff.domain.staff.family.StaffFamilyId;

public interface StaffFamilyCommandDbPort {

	Optional<StaffFamily> select(StaffFamilyId id);	

	void save(StaffFamily entity);
	
	void delete(StaffFamilyId id);
}
