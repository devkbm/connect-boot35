package com.like.hrm.staff.application.port.in.staff;

import java.util.List;

public interface StaffCreateExcelUploadUseCase {

	void upload(List<StaffCreateExcelUploadDTO> dtos);
}
