package com.like.system.file.application.port.in;

import com.like.system.file.application.dto.FileDTO;

public interface FileServerDownloadUseCase {

	FileDTO getDownloadFile(String fileInfoId);		
}
