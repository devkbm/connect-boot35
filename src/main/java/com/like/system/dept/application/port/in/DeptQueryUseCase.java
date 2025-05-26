package com.like.system.dept.application.port.in;

import java.util.List;

import com.like.system.dept.application.dto.DeptQueryDTO;
import com.like.system.dept.application.dto.DeptSaveDTO;

public interface DeptQueryUseCase {
	List<DeptSaveDTO> select(DeptQueryDTO dto);
}
