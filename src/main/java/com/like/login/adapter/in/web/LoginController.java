package com.like.login.adapter.in.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import java.time.LocalDate;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.web.util.WebRequestUtil;
import com.like.login.application.port.in.AuthenticationToken;
import com.like.login.application.port.in.AuthenticationTokenSelectUseCase;
import com.like.login.event.LoginSuccessEvent;
import com.like.system.user.export.SystemUserLoginDTO;
import com.like.system.user.export.SystemUserLoginDTOSelectUseCase;

@RestController
public class LoginController {		
	
	AuthenticationManager authenticationManager;	
	ApplicationEventPublisher eventPublisher;
	SystemUserLoginDTOSelectUseCase loginDTOSelectUseCase;
	AuthenticationTokenSelectUseCase authTokenSelectUseCase;
			
	public LoginController(
			AuthenticationManager authenticationManager,
			ApplicationEventPublisher eventPublisher,
			SystemUserLoginDTOSelectUseCase loginDTOSelectUseCase,						  						 
			AuthenticationTokenSelectUseCase authTokenSelectUseCase
			) {				
		this.authenticationManager = authenticationManager;
		this.eventPublisher = eventPublisher;		
		this.loginDTOSelectUseCase = loginDTOSelectUseCase;			
		this.authTokenSelectUseCase = authTokenSelectUseCase;					
	}
		 
	
	@PostMapping("/api/system/user/login")
	public AuthenticationToken login(@RequestBody @Valid LoginRequestDTO dto, HttpServletRequest request) {			
						         		 							                   
		//String ipAddress = WebRequestUtil.getIpAddress(request);
		//System.out.println("접속 IP주소: " + ipAddress);
		
		// 로그인 요청정보 SpringSecurityUserService에서 사용하기 위해 THREAD_LOCAL에 저장
		LoginRequestContext.set(dto);
														
		SystemUserLoginDTO systemUser = loginDTOSelectUseCase.get(dto.staffNo(), dto.companyCode());		
		
		// 스프링 시큐리티 인증
		UsernamePasswordAuthenticationToken securityToken = new UsernamePasswordAuthenticationToken(dto.staffNo(), dto.password(), systemUser.authorities());											
		//securityToken.setDetails("추가정보 입력가능");
		Authentication authentication = authenticationManager.authenticate(securityToken); 				
		SecurityContextHolder.getContext().setAuthentication(authentication);
		request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
		
		//로그인 요청정보 THREAD_LOCAL에서 제거
		LoginRequestContext.remove();
		
		this.eventPublisher.publishEvent(new LoginSuccessEvent(dto.companyCode(), dto.staffNo(), LocalDate.now(), "login"));
						
		return authTokenSelectUseCase.select(dto.staffNo(), dto.companyCode(), request.getSession().getId(), WebRequestUtil.getIpAddress(request));
	}
	
	@GetMapping("/api/system/user/logout")
	public boolean logout(HttpServletRequest request, HttpSession session) {			
						         		 							                   
		//String ipAddress = WebRequestUtil.getIpAddress(request);
		//System.out.println("접속 IP주소: " + ipAddress);
		
		if (session != null) {
			session.invalidate();
		}
		
		SecurityContext context = SecurityContextHolder.getContext();
		SecurityContextHolder.clearContext();		
		context.setAuthentication(null);
		
		return session == null || request.isRequestedSessionIdValid() ? true : false;
	}
	
}
