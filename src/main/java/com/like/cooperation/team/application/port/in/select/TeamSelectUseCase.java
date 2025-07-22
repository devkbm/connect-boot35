package com.like.cooperation.team.application.port.in.select;

import com.like.cooperation.team.application.port.in.save.TeamSaveDTO;

public interface TeamSelectUseCase {
	TeamSaveDTO select(Long teamId);
}
