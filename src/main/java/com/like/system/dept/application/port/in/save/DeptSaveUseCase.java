package com.like.system.dept.application.port.in.save;

public interface DeptSaveUseCase {
	
	boolean exists(String companyCode, String deptCode);
	
	void save(DeptSaveDTO dto);
}
