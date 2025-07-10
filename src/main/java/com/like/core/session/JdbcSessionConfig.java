package com.like.core.session;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

// maxInactiveIntervalInSeconds : default 1800sec(30 minute)
@Configuration
@EnableJdbcHttpSession(maxInactiveIntervalInSeconds = 600)
public class JdbcSessionConfig {

	 @Bean             
     HttpSessionEventPublisher httpSessionEventPublisher() {   
       return new HttpSessionEventPublisher();  
     }

}