package com.like.system.dept.application.port.in.select;

public interface DeptSelectUseCase {
	DeptSelectDTO select(String companyCode, String deptCode);	
}
