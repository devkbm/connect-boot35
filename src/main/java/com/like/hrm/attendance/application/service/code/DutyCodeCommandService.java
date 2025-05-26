package com.like.hrm.attendance.application.service.code;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.attendance.adapter.out.db.code.WorkChangeCodeRepository;
import com.like.hrm.attendance.application.dto.code.WorkChangeCodeDTO;
import com.like.hrm.attendance.domain.code.WorkChangeCode;

@Service
@Transactional
public class DutyCodeCommandService {

	private WorkChangeCodeRepository repository;
			
	public DutyCodeCommandService(WorkChangeCodeRepository repository) {
		this.repository = repository;		
	}
	
	public WorkChangeCode getDutyCode(String dutyCode) {
		return this.repository.findById(dutyCode).orElse(null);
	}
	
	public void saveDutyCode(WorkChangeCode dutyCode) {
		this.repository.save(dutyCode);
	}
	
	public void saveDutyCode(WorkChangeCodeDTO.SaveDutyCode dto) {
		WorkChangeCode entity = repository.findById(dto.getDutyCode()).orElse(null);
		
		if (entity == null) {
			entity = dto.newEntity();
		} else {			
			dto.modifyEntity(entity);
		}
				
		this.repository.save(entity);		
	}	
	
	public void deleteDutyCode(String dutyCode) {		
		this.repository.deleteById(dutyCode);
	}
		
	
}
