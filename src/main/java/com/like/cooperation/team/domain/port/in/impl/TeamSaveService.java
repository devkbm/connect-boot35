package com.like.cooperation.team.domain.port.in.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.team.domain.Team;
import com.like.cooperation.team.domain.port.in.TeamSaveUseCase;
import com.like.cooperation.team.domain.port.in.dto.TeamSaveDTO;
import com.like.cooperation.team.domain.port.out.TeamCommandDbPort;
import com.like.system.user.export.SystemUserDTOSelectUseCase;

@Transactional
@Service
public class TeamSaveService implements TeamSaveUseCase {

	TeamCommandDbPort dbPort;
	SystemUserDTOSelectUseCase userSelectUseCase;
	
	TeamSaveService(TeamCommandDbPort dbPort,
			SystemUserDTOSelectUseCase userSelectUseCase) {
		this.dbPort = dbPort;
		this.userSelectUseCase = userSelectUseCase;
	}
	
	@Override
	public void save(TeamSaveDTO dto) {
		Team entity = dto.teamId() == null ? null : dbPort.select(dto.teamId());
		
		if (entity == null) {
			entity = dto.newEntity(userSelectUseCase);
		} else {
			dto.modify(entity, userSelectUseCase);
		}
		
		dbPort.save(entity);
	}

}
