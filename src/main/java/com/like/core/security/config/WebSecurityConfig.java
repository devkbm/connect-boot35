package com.like.core.security.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.Session;
import org.springframework.session.security.SpringSessionBackedSessionRegistry;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.like.core.security.CustomAuthenticationEntryPoint;
import com.like.core.security.SpaCsrfTokenRequestHandler;
import com.like.core.security.oauth2.CustomAuthorizationRequestResolver;
import com.like.core.security.oauth2.CustomOAuth2UserService;
import com.like.core.security.oauth2.OAuth2AuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
//@Profile("!localtest")
@Profile("prod")
public class WebSecurityConfig<S extends Session> {

	private final FindByIndexNameSessionRepository<S> sessionRepository;
	private final CustomOAuth2UserService customOAuth2UserService;
	private final CustomAuthorizationRequestResolver customAuthorizationRequestResolver;
	private final OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;		
	
	WebSecurityConfig(
			FindByIndexNameSessionRepository<S> sessionRepository,
			CustomOAuth2UserService customOAuth2UserService,
			CustomAuthorizationRequestResolver customAuthorizationRequestResolver,
			OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler
			) {
		this.sessionRepository = sessionRepository;
		this.customOAuth2UserService = customOAuth2UserService;
		this.customAuthorizationRequestResolver = customAuthorizationRequestResolver;
		this.oAuth2AuthenticationSuccessHandler = oAuth2AuthenticationSuccessHandler;
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
			/*
		    .csrf((csrf) -> csrf
					.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())   
					.csrfTokenRequestHandler(new SpaCsrfTokenRequestHandler())   
			)
			*/
			.cors(cors -> cors.configurationSource(corsConfigurationSource()))			
			.sessionManagement((s) -> s.sessionFixation().changeSessionId().maximumSessions(1).sessionRegistry(sessionRegistry()))
			.securityContext((securityContext) -> securityContext.requireExplicitSave(true))
			.authorizeHttpRequests(authorize -> 
				authorize.requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
						.requestMatchers("/api/system/user/login").permitAll()			// 로그인 API						
						.anyRequest().authenticated()
						//.anyRequest().permitAll()
						
						)								
			.oauth2Login(customConfigurer -> customConfigurer
				.successHandler(oAuth2AuthenticationSuccessHandler)
				.authorizationEndpoint(endPointConfig -> endPointConfig.authorizationRequestResolver(customAuthorizationRequestResolver))
				.userInfoEndpoint(endPointConfig -> endPointConfig.userService(customOAuth2UserService))														
			)
			.exceptionHandling((auth) -> auth.authenticationEntryPoint(new CustomAuthenticationEntryPoint("/login")))	// HTTP STATUS 302 -> 401 Unauthorized 로 변경
			//.oauth2Login(Customizer.withDefaults())
			//.oauth2Client(Customizer.withDefaults())
			/*
			.logout(logout -> logout.logoutUrl("/api/system/user/logout")
									.invalidateHttpSession(true)
									.deleteCookies("JSESSIONID")			
									.logoutSuccessUrl("/")
									.permitAll())
									*/
			;
				
			
		return http.build();
	}		
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
       CorsConfiguration configuration = new CorsConfiguration();       

       configuration.setAllowedOriginPatterns(Arrays.asList("*"));
       //configuration.setAllowedOriginPatterns(Arrays.asList("https://localhost:4200","https://4200-firebase-connect-angular19-antdgit-1746601239828.cluster-zumahodzirciuujpqvsniawo3o.cloudworkstations.dev:[*]"));
       //configuration.addAllowedOrigin("http://localhost:4200");       
       //configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200","http://175.114.176.195:4200"));       
                           
       //configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));       
                    
       configuration.addAllowedMethod("*");
       // Request Header에 Http default 이외에 정해진 것만 허용한다.
       /*
       configuration.setAllowedHeaders(Arrays.asList("Origin", "Accept", "X-Requested-With", "Content-Type", 
    		   										 "remember-me", "x-auth-token", "Authorization", "x-xsrf-token", "XSRF-TOKEN","X-Access-Token", 
    		   										 "Access-Control-Allow-Origin","Access-Control-Request-Method","Access-Control-Request-Headers"));
       */
       configuration.setAllowedHeaders(Arrays.asList("*"));
                           
       // browser에서 Access-Control-Allow-Credentials: true가 없으면 거절한다. 즉, xmlhttprequest header에 쿠키가 있어야 한다.
       configuration.setAllowCredentials(true);
       
       // preflight가 전송된 후 60분 이후 만료된다.
       configuration.setMaxAge(3600L);
       
       UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
       source.registerCorsConfiguration("/**", configuration);
       
       return source;
	}
	
	@Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
	
	@Bean
	PasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SpringSessionBackedSessionRegistry<S> sessionRegistry() {
		return new SpringSessionBackedSessionRegistry<>(this.sessionRepository);
	}
	
	@Bean                                                        
	WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers("/static/**");
	}
}

