package com.like.hrm.staff.application.port.in.staff;

import com.like.excel.upload.ExcelHeader;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StaffCreateExcelUploadDTO {

	String clientAppUrl;
	@ExcelHeader("회사코드") String companyCode;		
	@ExcelHeader("직원번호") String staffNo;
	@ExcelHeader("직원명") String name;
	@ExcelHeader("주민등록번호") String residentRegistrationNumber;
	@ExcelHeader("영문직원명") String nameEng;	
}
