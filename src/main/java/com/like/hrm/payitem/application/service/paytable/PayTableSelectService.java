package com.like.hrm.payitem.application.service.paytable;

import org.springframework.stereotype.Service;

import com.like.hrm.payitem.application.dto.paytable.PayTableFormDTO;
import com.like.hrm.payitem.application.dto.paytable.PayTableFormDTOMapper;
import com.like.hrm.payitem.application.port.in.paytable.PayTableSelectUseCase;
import com.like.hrm.payitem.application.port.out.PayTableCommandDbPort;

@Service
public class PayTableSelectService implements PayTableSelectUseCase {

	PayTableCommandDbPort dbPort;
	
	PayTableSelectService(PayTableCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
		
	@Override
	public PayTableFormDTO select(String id) {		
		return PayTableFormDTOMapper.toDTO(this.dbPort.select(id).orElse(null));
	}

}
