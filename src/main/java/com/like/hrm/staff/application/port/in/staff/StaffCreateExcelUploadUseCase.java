package com.like.hrm.staff.application.port.in.staff;

import java.util.List;

import com.like.hrm.staff.application.dto.staff.StaffCreateExcelUploadDTO;

public interface StaffCreateExcelUploadUseCase {

	void upload(List<StaffCreateExcelUploadDTO> dtos);
}
