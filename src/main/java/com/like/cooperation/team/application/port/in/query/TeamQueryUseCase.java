package com.like.cooperation.team.application.port.in.query;

import java.util.List;

import com.like.cooperation.team.domain.Team;
import com.like.cooperation.team.domain.TeamMember;
import com.like.system.user.export.SystemUserDTO;

public interface TeamQueryUseCase {
	List<Team> selectTeamList(TeamQueryDTO dto);
	
	List<TeamMember> selectTeamMemeberList(Long id);
	
	//List<SystemUserDTO> selectAllMemberList(SystemUserQueryDTO dto);
}
