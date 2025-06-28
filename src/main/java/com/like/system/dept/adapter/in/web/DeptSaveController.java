package com.like.system.dept.adapter.in.web;

import jakarta.validation.Valid;

import static com.like.core.web.util.ResponseEntityUtil.toList;
import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.dept.application.port.in.save.DeptSaveDTO;
import com.like.system.dept.application.port.in.save.DeptSaveUseCase;

@RestController
public class DeptSaveController {
	
	private DeptSaveUseCase useCase;	
	
	public DeptSaveController(DeptSaveUseCase useCase) {
		this.useCase = useCase;		
	}
	
	@GetMapping("/api/system/dept/{id}/check")
	public ResponseEntity<?> getValidateDeptDuplication(@RequestParam String companyCode, @PathVariable String id) {
							
		Boolean exist = useCase.exists(companyCode, id);  	
						
		return toOne(exist, exist ? "중복된 부서 코드가 있습니다." : "사용가능한 부서 코드입니다.");
	}
		
	@PostMapping("/api/system/dept")
	public ResponseEntity<?> saveDept(@Valid @RequestBody DeptSaveDTO dto) {			
																
		useCase.save(dto);		
											 				
		return toList(null, MessageUtil.getSaveMessage(1));
	}			
	
}
