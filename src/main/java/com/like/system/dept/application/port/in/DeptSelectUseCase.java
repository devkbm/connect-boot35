package com.like.system.dept.application.port.in;

import com.like.system.dept.application.dto.DeptSaveDTO;

public interface DeptSelectUseCase {
	DeptSaveDTO select(String companyCode, String deptCode);	
}
