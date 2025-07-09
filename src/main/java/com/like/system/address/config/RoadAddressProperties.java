package com.like.system.address.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * src/main/resources/application-roadaddress.properties 
 */
/*
@Component
@Data
@ConfigurationProperties(prefix = "roadaddress")
public class RoadAddressProperties {
	String confmKey;
	String apiUrl;
}
*/


@ConfigurationProperties(prefix = "roadaddress")
public record RoadAddressProperties(
		String confmKey, 
		String apiUrl
		) {
}

