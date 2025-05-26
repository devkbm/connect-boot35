package com.like.cooperation.team.domain.port.out;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.cooperation.team.domain.Team;
import com.like.cooperation.team.domain.TeamMember;
import com.like.cooperation.team.domain.port.in.dto.TeamQueryDTO;

@Repository
public interface TeamQueryRepository {

	List<Team> getTeamList(TeamQueryDTO searchCondition);	
	
	List<TeamMember> getTeamMemberList(Long teamId);
}
