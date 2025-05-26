package com.like.cooperation.team.domain.port.in;

import com.like.cooperation.team.domain.port.in.dto.TeamSaveDTO;

public interface TeamSelectUseCase {
	TeamSaveDTO select(Long teamId);
}
