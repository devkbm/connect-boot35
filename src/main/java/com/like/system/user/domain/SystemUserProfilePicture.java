package com.like.system.user.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Embeddable
public class SystemUserProfilePicture implements Serializable {
	
	private static final long serialVersionUID = 42161337448472145L;

	@Column(name="FK_FILE")
	String image;
			
	public void setImagePath(String path) {
		this.image = path;
	}
		
}
