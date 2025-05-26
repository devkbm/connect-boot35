package com.like.hrm.staff.application.port.out.staff;

import java.util.Optional;

import com.like.hrm.staff.domain.staff.license.StaffLicense;
import com.like.hrm.staff.domain.staff.license.StaffLicenseId;

public interface StaffLicenseCommandDbPort {

	Optional<StaffLicense> select(StaffLicenseId id);	

	void save(StaffLicense entity);
	
	void delete(StaffLicenseId id);
}
