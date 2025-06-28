package com.like.system.dept.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.like.system.dept.application.port.in.hierarchy.DeptHierarchyQueryDTO;
import com.like.system.dept.application.port.in.hierarchy.DeptHierarchyQueryUseCase;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DeptHierarchySelectController {

	DeptHierarchyQueryUseCase useCase;
	
	DeptHierarchySelectController(DeptHierarchyQueryUseCase useCase) {
		this.useCase = useCase;
	}

	@GetMapping("/api/system/depttree")
	public ResponseEntity<?> getDeptHierarchyList(@ModelAttribute @Valid DeptHierarchyQueryDTO dto) {
							
		log.info(dto.toString());
		
		List<?> list = useCase.query(dto);  						 						
		
		return toList(list, String.format("%d 건 조회되었습니다.", list.size()));
	}
	
}
