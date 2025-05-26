package com.like.hrm.staff.application.port.out.partner;

import java.util.Optional;

import com.like.hrm.staff.domain.partner.PartnerCompanyStaff;

public interface PartnerCompanyStaffCommandDbPort {

	Optional<PartnerCompanyStaff> select(String companyCode, String staffNo);
	
	void save(PartnerCompanyStaff entity);
	
	void delete(String companyCode, String staffNo);
	
}
