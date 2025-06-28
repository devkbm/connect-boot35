package com.like.system.dept.application.port.in.hierarchy;

import java.util.List;

public interface DeptHierarchyQueryUseCase {
	List<?> query(DeptHierarchyQueryDTO dto);
}
