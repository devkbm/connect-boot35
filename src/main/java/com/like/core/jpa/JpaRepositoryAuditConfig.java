package com.like.core.jpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.like.core.jpa.domain.AuditorDetails;
import com.like.core.security.audit.SpringSecurityAuditorAware;

@Configuration
@EnableJpaAuditing
@Profile("prod")
public class JpaRepositoryAuditConfig {
	
	@Bean
	AuditorAware<AuditorDetails> auditorProvider() {
	    return new SpringSecurityAuditorAware(); // AuditorAware 의 구현체 객체 생성	    
	}
}
