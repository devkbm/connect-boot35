package com.like.cooperation.board.application.port.in.post.upload;

import java.util.List;

public interface PostExcelUploadUseCase {

	void upload(List<PostExcelUploadDTO> dto, String userId);
}
