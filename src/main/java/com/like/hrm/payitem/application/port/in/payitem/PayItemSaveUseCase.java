package com.like.hrm.payitem.application.port.in.payitem;

import com.like.hrm.payitem.application.dto.payitem.PayItemFormDTO;

public interface PayItemSaveUseCase {
	void save(PayItemFormDTO dto);
}
