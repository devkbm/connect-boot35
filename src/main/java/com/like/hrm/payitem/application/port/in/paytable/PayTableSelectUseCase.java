package com.like.hrm.payitem.application.port.in.paytable;

import com.like.hrm.payitem.application.dto.paytable.PayTableFormDTO;

public interface PayTableSelectUseCase {

	PayTableFormDTO select(String id);
}
