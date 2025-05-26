package com.like.system.systemcode.adapter.out.db.data;

import java.util.List;

import com.like.system.systemcode.adapter.out.db.entity.JpaBizCode;

public interface BizCodeQueryRepository {
	
	List<JpaBizCode> getBizCodeList(String organizactionCode, String typeId);
}
