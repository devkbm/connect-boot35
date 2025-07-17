package com.like.system.user.application.port.in.social;

import java.util.List;

public interface SelectSystemUserSocialUseCase {

	List<SelectSystemUserSocialDTO> select(String userId); 
}
