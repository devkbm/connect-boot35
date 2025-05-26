package com.like.cooperation.team.domain.port.in;

import com.like.cooperation.team.domain.port.in.dto.TeamSaveDTO;

public interface TeamSaveUseCase {
	void save(TeamSaveDTO dto);
}
