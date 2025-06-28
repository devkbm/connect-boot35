package com.like.system.dept.application.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.dept.application.port.in.query.DeptQueryDTO;
import com.like.system.dept.application.port.in.query.DeptQueryUseCase;
import com.like.system.dept.application.port.in.save.DeptSaveDTO;
import com.like.system.dept.application.port.in.save.DeptSaveDTOMapper;
import com.like.system.dept.application.port.out.DeptQueryDbPort;

@Transactional(readOnly = true)
@Service
public class DeptQueryService implements DeptQueryUseCase {

	DeptQueryDbPort port;
	
	DeptQueryService(DeptQueryDbPort port) {
		this.port = port;
	}
	
	@Override
	public List<DeptSaveDTO> select(DeptQueryDTO dto) {
		return this.port.select(dto)
						.stream()
						.map(e -> DeptSaveDTOMapper.toDTO(e))
						.toList();
	}
}
