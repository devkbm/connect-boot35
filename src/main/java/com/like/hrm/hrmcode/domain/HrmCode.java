package com.like.hrm.hrmcode.domain;

import com.like.core.jpa.domain.AbstractAuditEntity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "HRMCODE")
public class HrmCode extends AbstractAuditEntity {			

	@EmbeddedId		
	HrmCodeId id;		
	
	@Column(name="CODE_NM")
	String codeName;
		
	@Column(name="USE_YN")
	boolean useYn = true;

	@Column(name="PRT_SEQ")
	Integer sequence;
	
	@Column(name="CMT")
	String comment;			
	
	@Column(name="EXTRA_INFO")
	String extraInfo;		
		
	public HrmCode(			
			HrmCodeId id,
			String codeName,
	 	   	boolean useYn,
	 	   	Integer sequence,
	 	   	String comment,
	 	   	String extraInfo
	 	   	) {		
		this.id = id;				
		this.codeName = codeName;		
		this.useYn = useYn;
		this.sequence = sequence;
		this.comment = comment;
		this.extraInfo = extraInfo;
	}
		
	public void modify(
			String codeName,
	 	   	boolean useYn,
	 	   	Integer sequence,
	 	   	String comment,
	 	   	String extraInfo
			) {	
		this.codeName = codeName;
		this.useYn = useYn;
		this.sequence = sequence;
		this.comment = comment;
		this.extraInfo = extraInfo;
	}	
	
}
