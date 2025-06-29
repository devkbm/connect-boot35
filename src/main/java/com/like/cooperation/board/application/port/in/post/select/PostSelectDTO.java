package com.like.cooperation.board.application.port.in.post.select;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.like.cooperation.board.adapter.out.file.PostAttachedFileServerRepository;
import com.like.cooperation.board.domain.post.PostAttachedFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostSelectDTO {

	LocalDateTime createdDt;
	String createdBy;
	LocalDateTime modifiedDt;
	String modifiedBy;
	String userName;
	String boardId;
	String postId;
	String postParentId;
	String title;
	String contents;
	String pwd;
	int hitCount;				
	Integer depth;	
	Boolean editable;	
	List<PostAttachedFileDTO> fileList;
	
	@Builder
	public record PostAttachedFileDTO(
			String uid,
			String name,
			Long size,
			String contentType,
			String url
			) {

	}
	
	public void addFileList(List<PostAttachedFile> files) {
    	if (this.fileList == null) this.fileList = new ArrayList<>();
		
		//List<PostAttachedFileDTO> responseList = new ArrayList<>();	
    	    	    
    	for (PostAttachedFile file : files) {							
    		this.fileList.add(
					PostAttachedFileDTO
						.builder()
						.uid(file.getPostFileId().toString())
						.name(file.getFileName())
						.size(file.getSize())
						.contentType(file.getContentType())
						.url(PostAttachedFileServerRepository.fileDownLoadUrl+file.getPostFileId())
						.build()
						);				
		}
    	    	
    	//this.setFileList(responseList);    	
    }
	
	/*
	List<FileResponseDTO> fileList;		
	public void addFileList(List<FileInfoDTO> fileInfoList) {
    	List<FileResponseDTO> responseList = new ArrayList<>();	
    	
    	for (FileInfoDTO fileInfo : fileInfoList) {							
			responseList.add(FileResponseDTO.convert(fileInfo));				
		}
    	    	
    	this.setFileList(responseList);    	
    }
    */
}
