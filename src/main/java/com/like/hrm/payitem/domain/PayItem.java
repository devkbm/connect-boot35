package com.like.hrm.payitem.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.like.core.jpa.domain.AbstractAuditEntity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "HRMPAYITEM")
@EntityListeners(AuditingEntityListener.class)
public class PayItem extends AbstractAuditEntity {

	@EmbeddedId	
	PayItemId id;
	
	@Column(name="PAY_ITEM_NAME")
	String itemName;
	
	// 지급분, 공제분, 합산분
	@Column(name="PAY_ITEM_TYPE")
	String type;
	
	// 급여테이블 사용여부
	@Column(name="PAY_TABLE_YN")
	Boolean usePayTable;	
	
	@Column(name="SEQ")
	Integer seq;
	
	@Column(name="CMT")
	String comment;
	
	public PayItem(
			PayItemId id,
			String itemName,
			String type,
			Boolean usePayTable,
			Integer seq,
			String comment
			) {		
		this.id = id;
		this.itemName = itemName;
		this.type = type;
		this.seq = seq;
		this.comment = comment;
		this.usePayTable = usePayTable;
	}
	
	public void modify(
			String itemName,
			String type,
			Boolean usePayTable,
			Integer seq,
			String comment
			) {
		this.itemName = itemName;
		this.type = type;
		this.seq = seq;
		this.comment = comment;
		this.usePayTable = usePayTable;
	}	
	
}
