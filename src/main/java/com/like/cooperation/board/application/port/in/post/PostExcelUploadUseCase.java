package com.like.cooperation.board.application.port.in.post;

import java.util.List;

import com.like.cooperation.board.application.dto.post.PostExcelUploadDTO;

public interface PostExcelUploadUseCase {

	void upload(List<PostExcelUploadDTO> dto, String userId);
}
