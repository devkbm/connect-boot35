package com.like.cooperation.board.domain.post;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.like.core.jpa.domain.AbstractAuditEntity;

import io.hypersistence.utils.hibernate.id.Tsid;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * <p>게시글 첨부파일 클래스</p>
 * 
 * [상세내용] <br>
 *   1. <br>
 * [제약조건] <br>
 *   1. <br>
 */
@ToString(exclude= {"post"})
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true, value = {"post"})
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "GRWPOSTFILE")
public class PostAttachedFile extends AbstractAuditEntity implements Serializable {
		
		
	private static final long serialVersionUID = 1933620773768936638L;

	@Id
	@Tsid
	@Column(name="POST_FILE_ID")
	Long postFileId;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POST_ID", nullable = false)
	Post post; 	
		
	//@Column(name="FILE_ID", columnDefinition = "BINARY(16)")
	//UUID fileInfo;
	@Column(name="FILE_ID")
	Long fileInfo;

	@Column(name="FILE_PATH")
	String path;
	
	@Column(name="UUID")
	String uuid;
	
	@Column(name="FILE_NM")
	String fileName;		
	
	@Column(name="FILE_SIZE")
	long size;
	
	@Column(name="CONTENT_TYPE")
	String contentType;
	
	public PostAttachedFile(Post post, String fileInfo) {		
		this.post = post;
		this.fileInfo = Long.parseLong(fileInfo);		
	}	
	
	public PostAttachedFile(Post post, String serverUploadPath, MultipartFile file) {
		this.post = post;
		
		this.path = serverUploadPath;
		this.uuid = UUID.randomUUID().toString();		
		this.fileName = file.getOriginalFilename();
		this.size = file.getSize();
		this.contentType = file.getContentType();
	}
	
}


