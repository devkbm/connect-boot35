package com.like.system.dept.application.service;

import org.springframework.stereotype.Service;

import com.like.system.dept.application.port.in.delete.DeptDeleteUseCase;
import com.like.system.dept.application.port.in.save.DeptSaveDTO;
import com.like.system.dept.application.port.in.save.DeptSaveDTOMapper;
import com.like.system.dept.application.port.in.save.DeptSaveUseCase;
import com.like.system.dept.application.port.in.select.DeptSelectDTO;
import com.like.system.dept.application.port.in.select.DeptSelectDTOMapper;
import com.like.system.dept.application.port.in.select.DeptSelectUseCase;
import com.like.system.dept.application.port.out.DeptCommandDbPort;
import com.like.system.dept.domain.Dept;

@Service
public class DeptCommandService implements DeptSelectUseCase, DeptSaveUseCase, DeptDeleteUseCase {

	DeptCommandDbPort port;
	
	public DeptCommandService(DeptCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public boolean exists(String companyCode, String deptCode) {
		return this.port.exists(companyCode, deptCode);
	}
	
	@Override
	public DeptSelectDTO select(String companyCode, String deptCode) {		
		Dept entity = this.port.select(companyCode, deptCode).orElse(null);
		
		return DeptSelectDTOMapper.toDTO(entity);
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
