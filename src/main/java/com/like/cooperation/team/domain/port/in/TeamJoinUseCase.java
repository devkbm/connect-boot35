package com.like.cooperation.team.domain.port.in;

public interface TeamJoinUseCase {
	void join(Long teamId, String companyCode, String userId);
}
