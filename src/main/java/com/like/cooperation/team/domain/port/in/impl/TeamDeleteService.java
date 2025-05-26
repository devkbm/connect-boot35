package com.like.cooperation.team.domain.port.in.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.team.domain.port.in.TeamDeleteUseCase;
import com.like.cooperation.team.domain.port.out.TeamCommandDbPort;

@Transactional
@Service
public class TeamDeleteService implements TeamDeleteUseCase {

	TeamCommandDbPort dbPort;
	
	TeamDeleteService(TeamCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void delete(Long teamId) {
		this.dbPort.delete(teamId);
	}

}
