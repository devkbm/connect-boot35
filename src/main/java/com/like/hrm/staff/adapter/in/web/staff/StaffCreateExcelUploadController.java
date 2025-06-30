package com.like.hrm.staff.adapter.in.web.staff;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.like.excel.upload.ExcelUploader;
import com.like.hrm.staff.application.port.in.staff.StaffCreateExcelUploadDTO;
import com.like.hrm.staff.application.port.in.staff.StaffCreateExcelUploadUseCase;

@RestController
public class StaffCreateExcelUploadController {

	StaffCreateExcelUploadUseCase useCase;
	
	StaffCreateExcelUploadController(StaffCreateExcelUploadUseCase useCase) {
		this.useCase = useCase;
	}
	
	@PostMapping("/api/hrm/staff/create/excel")
	public ResponseEntity<?> newStaff(MultipartFile file) {											
							
		ExcelUploader<StaffCreateExcelUploadDTO> uploader = new ExcelUploader<>(StaffCreateExcelUploadDTO.class);
		List<StaffCreateExcelUploadDTO> list = uploader.map(file);
		
		useCase.upload(list);
											 				
		return toList(null, "직원 %s 건, 생성되었습니다.".formatted(list.size()));
	}		
}
