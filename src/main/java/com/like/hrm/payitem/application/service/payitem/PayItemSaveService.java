package com.like.hrm.payitem.application.service.payitem;

import org.springframework.stereotype.Service;

import com.like.hrm.payitem.application.dto.payitem.PayItemFormDTO;
import com.like.hrm.payitem.application.dto.payitem.PayItemFormDTOMapper;
import com.like.hrm.payitem.application.port.in.payitem.PayItemSaveUseCase;
import com.like.hrm.payitem.application.port.out.PayItemCommandDbPort;
import com.like.hrm.payitem.domain.PayItem;
import com.like.hrm.payitem.domain.PayItemId;

@Service
public class PayItemSaveService implements PayItemSaveUseCase {

	PayItemCommandDbPort dbPort;
	
	PayItemSaveService(PayItemCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void save(PayItemFormDTO dto) {
		PayItem entity = this.dbPort.select(new PayItemId(dto.companyCode(), dto.itemCode())).orElse(null);
		
		if (entity == null) {
			entity = PayItemFormDTOMapper.newEntity(dto);
		} else {
			entity = PayItemFormDTOMapper.modifyEntity(entity, dto);
		}
		
		dbPort.save(entity);		
	}
	
}
