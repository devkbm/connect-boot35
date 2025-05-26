package com.like.hrm.staff.application.port.in.staff;

import java.io.File;
import java.io.IOException;

public interface StaffImageUploadUseCase {		
	String saveUploadImagePath(String companyCode, String staffNo, File file)  throws IOException;
}
