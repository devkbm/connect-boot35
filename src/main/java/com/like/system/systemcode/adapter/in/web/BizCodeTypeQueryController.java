package com.like.system.systemcode.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.common.dto.HtmlSelectOptionRecord;
import com.like.common.dto.HtmlSelectOptionable;
import com.like.core.message.MessageUtil;
import com.like.system.systemcode.adapter.out.db.entity.JpaBizTypeEnum;
import com.like.system.systemcode.application.port.in.query.BizCodeTypeQueryResultDTO;
import com.like.system.systemcode.application.port.in.query.BizCodeTypeQueryUseCase;

@RestController
public class BizCodeTypeQueryController {

	private BizCodeTypeQueryUseCase service;
	
	public BizCodeTypeQueryController(BizCodeTypeQueryUseCase service) {
		this.service = service;
	}
	
	@GetMapping("/api/system/bizcodetype/system")
	public ResponseEntity<?> getSystemList() {				
		
		List<HtmlSelectOptionRecord> list = HtmlSelectOptionable.fromEnum(JpaBizTypeEnum.class);			
		
		return toList(list, MessageUtil.getQueryMessage(list.size()));
	}
	
	@GetMapping("/api/system/bizcodetype")
	public ResponseEntity<?> getBizCodeTypeList(@RequestParam String companyCode) {			
		List<BizCodeTypeQueryResultDTO> list = service.select(companyCode);											   
					
		return toList(list, MessageUtil.getQueryMessage(list.size()));
	}
}
