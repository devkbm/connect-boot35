package com.like.hrm.staff.application.service.partner;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.application.dto.partner.PartnerCompanyStaffFormDTO;
import com.like.hrm.staff.application.dto.partner.PartnerCompanyStaffFormDTOMapper;
import com.like.hrm.staff.application.port.in.partner.PartnerCompanyStaffSaveUseCase;
import com.like.hrm.staff.application.port.out.partner.PartnerCompanyStaffCommandDbPort;
import com.like.hrm.staff.domain.partner.PartnerCompanyStaff;

@Service
public class PartnerCompanyStaffSaveService implements PartnerCompanyStaffSaveUseCase {

	PartnerCompanyStaffCommandDbPort dbPort;
	
	PartnerCompanyStaffSaveService(PartnerCompanyStaffCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void save(PartnerCompanyStaffFormDTO dto) {
		
		PartnerCompanyStaff entity = this.dbPort.select(dto.companyCode(), dto.staffNo()).orElse(null);
		
		if (entity == null) {
			entity = PartnerCompanyStaffFormDTOMapper.create(dto);
 		} else {
 			PartnerCompanyStaffFormDTOMapper.modify(entity, dto);
 		}
		
		this.dbPort.save(entity);		
	}

}
