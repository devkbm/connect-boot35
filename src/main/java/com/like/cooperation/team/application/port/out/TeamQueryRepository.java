package com.like.cooperation.team.application.port.out;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.cooperation.team.application.port.in.query.TeamQueryDTO;
import com.like.cooperation.team.domain.Team;
import com.like.cooperation.team.domain.TeamMember;

@Repository
public interface TeamQueryRepository {

	List<Team> getTeamList(TeamQueryDTO searchCondition);	
	
	List<TeamMember> getTeamMemberList(Long teamId);
}
