package com.like.hrm.staff.application.service.partner;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.application.dto.partner.PartnerCompanyStaffFormDTO;
import com.like.hrm.staff.application.dto.partner.PartnerCompanyStaffFormDTOMapper;
import com.like.hrm.staff.application.port.in.partner.PartnerCompanyStaffSelectUseCase;
import com.like.hrm.staff.application.port.out.partner.PartnerCompanyStaffCommandDbPort;

@Service
public class PartnerCompanyStaffSelectService implements PartnerCompanyStaffSelectUseCase {

	PartnerCompanyStaffCommandDbPort dbPort;
	
	PartnerCompanyStaffSelectService(PartnerCompanyStaffCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public PartnerCompanyStaffFormDTO select(String companyCode, String staffNo) {		
		return PartnerCompanyStaffFormDTOMapper.toDTO(this.dbPort.select(companyCode, staffNo).orElse(null));
	}

}
