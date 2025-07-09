package com.like.system.user.adapter.out.file;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.experimental.Accessors;


@ConfigurationProperties(prefix = "user-image")
public record UserImagePathProperties(
		String uploadPath
		) {

}


/*
@Component
@Accessors(fluent = true)
@Data
@ConfigurationProperties(prefix = "user-image")
public class UserImagePathProperties {
	String uploadPath;
}
*/