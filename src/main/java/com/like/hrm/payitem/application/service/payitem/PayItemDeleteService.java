package com.like.hrm.payitem.application.service.payitem;

import org.springframework.stereotype.Service;

import com.like.hrm.payitem.application.port.in.payitem.PayItemDeleteUseCase;
import com.like.hrm.payitem.application.port.out.PayItemCommandDbPort;
import com.like.hrm.payitem.domain.PayItemId;

@Service
public class PayItemDeleteService implements PayItemDeleteUseCase {

	PayItemCommandDbPort dbPort;
	
	PayItemDeleteService(PayItemCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void delete(String companyCode, String itemCode) {
		this.dbPort.delete(new PayItemId(companyCode, itemCode));
	}

}
