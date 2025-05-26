package com.like.system.dept.application.service;

import org.springframework.stereotype.Service;

import com.like.system.dept.application.dto.DeptSaveDTO;
import com.like.system.dept.application.dto.DeptSaveDTOMapper;
import com.like.system.dept.application.port.in.DeptDeleteUseCase;
import com.like.system.dept.application.port.in.DeptSaveUseCase;
import com.like.system.dept.application.port.in.DeptSelectUseCase;
import com.like.system.dept.application.port.out.DeptCommandDbPort;
import com.like.system.dept.domain.Dept;

@Service
public class DeptCommandService implements DeptSelectUseCase, DeptSaveUseCase, DeptDeleteUseCase {

	DeptCommandDbPort port;
	
	public DeptCommandService(DeptCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public DeptSaveDTO select(String companyCode, String deptCode) {		
		Dept entity = this.port.select(companyCode, deptCode).orElse(null);
		
		return DeptSaveDTOMapper.toDTO(entity);
	}

	@Override
	public void save(DeptSaveDTO dto) {
		Dept parent = port.select(dto.companyCode(), dto.parentDeptCode()).orElse(null);
		
		this.port.save(DeptSaveDTOMapper.toEntity(dto, parent));		
	}

	@Override
	public void delete(String companyCode, String deptCode) {
		this.port.delete(companyCode, deptCode);		
	}
	
}
