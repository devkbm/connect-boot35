package com.like.hrm.payitem.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode(of = {"companyCode","itemCode"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class PayItemId implements Serializable {
	
	private static final long serialVersionUID = -5513189293265939387L;

	@Column(name="ORG_CD")
	String companyCode;
	
	@Column(name="PAY_ITEM_CODE")
	String itemCode;
	
	public PayItemId(String companyCode, String itemCode) {
		this.companyCode = companyCode;
		this.itemCode = itemCode;
	}
}
