package com.like.core.jpa.envers;

import org.hibernate.envers.RevisionListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class CustomRevisionEntityListener implements RevisionListener  {

	@Override
	public void newRevision(Object revisionEntity) {		
        CustomRevisionEntity customRevisionEntity = (CustomRevisionEntity) revisionEntity;
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((User)authentication.getPrincipal()).getUsername();
        
        customRevisionEntity.revisionUserId(username);        
	}

}
