package com.like.cooperation.board.application.port.in.post.upload;

import com.like.excel.upload.ExcelHeader;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Getter
@NoArgsConstructor
public class PostExcelUploadDTO {

	String clientAppUrl;
	@ExcelHeader("게시판ID")String boardId;
	@ExcelHeader("제목")String title;
	@ExcelHeader("내용")String contents;
}
