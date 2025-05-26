package com.like.cooperation.board.domain.post;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import org.hibernate.annotations.Comment;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Embeddable
public class PostPassword {

	@Comment("비밀번호")
	@Column(name="PWD")
    String password;
	
	public PostPassword(String password) {
		this.password = password;		
	}
}
