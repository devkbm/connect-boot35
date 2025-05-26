package com.like.hrm.staff.application.port.out.staff;

import java.util.Optional;

import com.like.hrm.staff.domain.staff.schoolcareer.StaffSchoolCareer;
import com.like.hrm.staff.domain.staff.schoolcareer.StaffSchoolCareerId;

public interface StaffSchoolCareerCommandDbPort {

	Optional<StaffSchoolCareer> select(StaffSchoolCareerId id);	

	void save(StaffSchoolCareer entity);
	
	void delete(StaffSchoolCareerId id);
}
