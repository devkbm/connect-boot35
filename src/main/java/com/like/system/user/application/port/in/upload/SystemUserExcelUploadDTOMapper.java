package com.like.system.user.application.port.in.upload;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class SystemUserExcelUploadDTOMapper {

	
	public static List<SystemUserExcelUploadDTO> map(MultipartFile file) {
		
		List<SystemUserExcelUploadDTO> list = new ArrayList<>();
		
		try (XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream())) {
			XSSFSheet worksheet = workbook.getSheetAt(0);
		    
		    /*
		     * 		String clientAppUrl,
			String userId,
			@NotBlank(message="조직코드를 선택해 주세요.")
			String companyCode,
			@NotBlank(message="직원번호를 입력해 주세요.")
			String staffNo,
			String name,
			String deptCode,		
			String mobileNum,
			String email,			
			Boolean enabled,
			List<String> roleList,
			List<String> menuGroupList
		    */
		    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
		        	        	       	      
		        DataFormatter formatter = new DataFormatter();		        
		        XSSFRow row = worksheet.getRow(i);
		        
		        SystemUserExcelUploadDTO dto = SystemUserExcelUploadDTO
	        		.builder()
	        		.userId(formatter.formatCellValue(row.getCell(0)))
	        		.companyCode(formatter.formatCellValue(row.getCell(1)))
	        		.staffNo(formatter.formatCellValue(row.getCell(2)))
	        		.name(formatter.formatCellValue(row.getCell(3)))
	        		.deptCode(formatter.formatCellValue(row.getCell(4)))
	        		.mobileNum(formatter.formatCellValue(row.getCell(5)))
	        		.email(formatter.formatCellValue(row.getCell(6)))
	        		.build();	    
		        
		        
		        list.add(dto);
		    }	
		} catch (IOException e) {
			e.printStackTrace();
		}
			    	    
	    return list;
	}
}
