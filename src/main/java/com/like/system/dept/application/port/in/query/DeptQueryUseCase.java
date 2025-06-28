package com.like.system.dept.application.port.in.query;

import java.util.List;

import com.like.system.dept.application.port.in.save.DeptSaveDTO;

public interface DeptQueryUseCase {
	List<DeptSaveDTO> select(DeptQueryDTO dto);
}
