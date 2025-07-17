package com.like.system.user.application.port.in.image;

import java.io.File;
import java.io.IOException;

public interface SystemUserImageUploadUseCase {			
	String upload(String companyCode, String userId, File file) throws IOException;
}
