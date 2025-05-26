package com.like.cooperation.board.domain.post;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;

import org.hibernate.annotations.Comment;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Embeddable
public class PostContents {

	@Comment("제목")
	@Column(name="TITLE")
	String title;
        
	@Comment("내용")
	@Column(name="CONTENTS")
	@Lob
    String contents;
	
	public PostContents(String title
						  ,String contents) {
		if (title == null || title == "") throw new IllegalArgumentException("게시글 제목은 필수 입력값입니다.");
		
		this.title = title;
		this.contents = contents;
	}
}
