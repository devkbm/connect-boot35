package com.like.hrm.hrmcode.application.service.hrmcode;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.like.hrm.hrmcode.application.dto.hrmcode.HrmCodeSelectDTO;
import com.like.hrm.hrmcode.application.dto.hrmcode.HrmCodeSelectDTOMapper;
import com.like.hrm.hrmcode.application.port.in.hrmcode.HrmCodeSelectUseCase;
import com.like.hrm.hrmcode.application.port.out.hrmcode.HrmCodeCommandDbPort;
import com.like.hrm.hrmcode.application.port.out.hrmcodetype.HrmCodeTypeCommandDbPort;
import com.like.hrm.hrmcode.domain.HrmCode;
import com.like.hrm.hrmcode.domain.HrmCodeId;
import com.like.hrm.hrmcode.domain.HrmCodeType;

@Service
public class HrmCodeSelectService implements HrmCodeSelectUseCase {

	HrmCodeCommandDbPort dbPort;
	HrmCodeTypeCommandDbPort codeTypeDbPort;
	
	HrmCodeSelectService(HrmCodeCommandDbPort dbPort, HrmCodeTypeCommandDbPort codeTypeDbPort) {
		this.dbPort = dbPort;
		this.codeTypeDbPort = codeTypeDbPort;
	}
		
	@Override
	public HrmCodeSelectDTO select(String type, String code) {	
		HrmCode entity = this.dbPort.select(new HrmCodeId(type, code)).orElse(null);
		HrmCodeType codeType = this.codeTypeDbPort.select(type).orElse(null);
		
		try {
			return HrmCodeSelectDTOMapper.toDTO(entity, codeType);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return null;
	}

}
