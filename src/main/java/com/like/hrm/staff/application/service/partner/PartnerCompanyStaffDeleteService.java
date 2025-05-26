package com.like.hrm.staff.application.service.partner;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.application.port.in.partner.PartnerCompanyStaffDeleteUseCase;
import com.like.hrm.staff.application.port.out.partner.PartnerCompanyStaffCommandDbPort;

@Service
public class PartnerCompanyStaffDeleteService implements PartnerCompanyStaffDeleteUseCase {

	PartnerCompanyStaffCommandDbPort dbPort;
	
	PartnerCompanyStaffDeleteService(PartnerCompanyStaffCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void delete(String companyCode, String staffNo) {
		this.dbPort.delete(companyCode, staffNo);
	}

}
