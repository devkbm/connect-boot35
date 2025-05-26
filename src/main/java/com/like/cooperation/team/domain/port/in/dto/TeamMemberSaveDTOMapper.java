package com.like.cooperation.team.domain.port.in.dto;

import com.like.cooperation.team.domain.TeamMember;

public class TeamMemberSaveDTOMapper {

	public static TeamMemberSaveDTO toDTO(TeamMember entity) {
		if (entity == null) return null;
					
		return TeamMemberSaveDTO.builder()
				   .teamId(entity.getTeam().getTeamId())
				   .userId(entity.getId().getUserId())
				   .authority(entity.getAuthority())
				   .build();
	}
}
