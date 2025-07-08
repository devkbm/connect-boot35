package com.like.core.security.oauth2;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {					
				
		OAuth2LoginRequestThreadLocal.remove();
		
		//String CLIENT_URL = "https://localhost:4200/oauth2/";
		String CLIENT_URL = "https://connect-one.zapto.org/oauth2/";
		
		getRedirectStrategy().sendRedirect(request, response, CLIENT_URL + request.getSession().getId());
	
	}

}
