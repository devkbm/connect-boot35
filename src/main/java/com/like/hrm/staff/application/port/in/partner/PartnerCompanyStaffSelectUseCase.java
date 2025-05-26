package com.like.hrm.staff.application.port.in.partner;

import com.like.hrm.staff.application.dto.partner.PartnerCompanyStaffFormDTO;

public interface PartnerCompanyStaffSelectUseCase {

	PartnerCompanyStaffFormDTO select(String companyCode, String staffNo);
}
