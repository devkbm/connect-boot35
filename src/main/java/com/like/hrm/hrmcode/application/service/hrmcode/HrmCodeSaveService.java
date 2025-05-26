
package com.like.hrm.hrmcode.application.service.hrmcode;

import static org.springframework.util.StringUtils.hasText;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.like.hrm.hrmcode.application.dto.hrmcode.HrmCodeSaveDTO;
import com.like.hrm.hrmcode.application.port.in.hrmcode.HrmCodeSaveUseCase;
import com.like.hrm.hrmcode.application.port.out.hrmcode.HrmCodeCommandDbPort;
import com.like.hrm.hrmcode.domain.HrmCode;
import com.like.hrm.hrmcode.domain.HrmCodeId;

@Service
public class HrmCodeSaveService implements HrmCodeSaveUseCase {

	HrmCodeCommandDbPort dbPort;
	
	HrmCodeSaveService(HrmCodeCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void save(HrmCodeSaveDTO dto) {
		HrmCode entity = null;
		
		if (hasText(dto.typeId()) && hasText(dto.code())) {
			entity = this.dbPort.select(new HrmCodeId(dto.typeId(), dto.code())).orElse(null);
		}
			
		if (entity == null) {
			try {
				entity = dto.newEntity();
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				entity = dto.modify(entity);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		dbPort.save(entity);		
	}
 
}
