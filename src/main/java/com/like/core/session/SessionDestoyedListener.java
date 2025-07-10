package com.like.core.session;

import org.springframework.context.ApplicationListener;
import org.springframework.session.Session;
import org.springframework.session.events.SessionDestroyedEvent;

public class SessionDestoyedListener implements ApplicationListener<SessionDestroyedEvent> {

	@Override
	public void onApplicationEvent(SessionDestroyedEvent event) {
		
		 Session session = event.getSession();	        	               
         //User sessionUser = session.getAttribute("USER");
		 
		 // 세션종료시 처리
	}

}
