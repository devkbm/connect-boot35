package com.like.hrm.staff.domain;

import java.time.LocalDate;

import com.like.core.jpa.domain.AbstractAuditEntity;
import com.like.hrm.staff.domain.staff.ResidentRegistrationNumber;
import com.like.hrm.staff.domain.staff.StaffId;
import com.like.hrm.staff.domain.staff.StaffName;

public abstract class AbstractStaff extends AbstractAuditEntity {

	StaffId id;
	
	StaffName name;
	
	ResidentRegistrationNumber residentRegistrationNumber;
	
	Boolean isStaff;
	
	String gender;
	
	LocalDate birthday;
	
	String workStateCode;
	
	String imagePath;
}
