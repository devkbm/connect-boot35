package com.like.hrm.attendance.application.service.code;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.attendance.adapter.out.db.code.WorkChangeCodeQueryRepository;
import com.like.hrm.attendance.application.dto.code.WorkChangeCodeDTO;
import com.like.hrm.attendance.domain.code.WorkChangeCode;

@Service
@Transactional(readOnly = true)
public class DutyCodeQueryService {

	private WorkChangeCodeQueryRepository repository;
	
	public DutyCodeQueryService(WorkChangeCodeQueryRepository dutyCodeRepository) {
		this.repository = dutyCodeRepository;
	}
	
	public List<WorkChangeCode> getDutyCodeList(WorkChangeCodeDTO.SearchDutyCode condition) {
		return this.repository.getDutyCodeList(condition);
	}
}
