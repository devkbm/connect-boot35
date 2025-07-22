package com.like.cooperation.team.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.team.application.port.in.save.TeamSaveDTO;
import com.like.cooperation.team.application.port.in.select.TeamSelectUseCase;
import com.like.cooperation.team.application.port.out.TeamCommandDbPort;

@Transactional
@Service
public class TeamSelectService implements TeamSelectUseCase {

	TeamCommandDbPort dbPort;
	
	TeamSelectService(TeamCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public TeamSaveDTO select(Long teamId) {
		return TeamSaveDTO.toDTO(this.dbPort.select(teamId));
	}

}
