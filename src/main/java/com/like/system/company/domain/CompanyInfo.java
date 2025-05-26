package com.like.system.company.domain;

import java.time.LocalDate;

import org.hibernate.envers.Audited;

import com.like.common.vo.Address;
import com.like.core.jpa.domain.AbstractAuditEntity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Getter
@Audited
@Entity
@Table(name = "COMCOMPANY")
public class CompanyInfo extends AbstractAuditEntity {

	@EmbeddedId
	CompanyInfoId id;
	
	@Column(name="ORG_NM")
	String companyName;
	
	// 사업자등록번호
	@Column(name="BIZ_REG_NO")
	String businessRegistrationNumber;
	
	// 법인번호
	@Column(name="CORP_NO")
	String coporationNumber;
	
	// 설립일
	@Column(name="ESTA_DT")
	LocalDate establishmentDate;
	
	// 대표자명(성명)
	@Column(name="REPR_NM")
	String nameOfRepresentative;
	
	// 공동대표자명1	
	@Column(name="TH1_CO_REPR_NM")
	String nameOfCoRepresentative1;
	
	// 공동대표자명2	
	@Column(name="TH2_CO_REPR_NM")
	String nameOfCoRepresentative2;
		
	// 본점 주소	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "address_type", column = @Column(name = "HEAD_ADDR_TYPE")),
        @AttributeOverride(name = "post_number", column = @Column(name = "HEAD_POST_NO")),
        @AttributeOverride(name = "main_address", column = @Column(name = "HEAD_MAIN_ADDR")),
        @AttributeOverride(name = "sub_address", column = @Column(name = "HEAD_SUB_ADDR"))
	})	
	Address headOffice;	
	
	// 사업장 주소
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "address_type", column = @Column(name = "BIZ_ADDR_TYPE")),
        @AttributeOverride(name = "post_number", column = @Column(name = "BIZ_POST_NO")),
        @AttributeOverride(name = "main_address", column = @Column(name = "BIZ_MAIN_ADDR")),
        @AttributeOverride(name = "sub_address", column = @Column(name = "BIZ_SUB_ADDR"))
	})	
	Address businessLocation;	
	
	// 업태
	@Column(name="BIZ_TYP_NM")
	String typeOfBusiness;
	
	// 종목
	@Column(name="BIZ_ITEM_NM")
	String itemOfBusiness;
	
	public CompanyInfo(
			String appUrl,
			String id,
			String companyName,
			String businessRegistrationNumber,
			String coporationNumber,
			String nameOfRepresentative,
			LocalDate establishmentDate
			) {
		this.setAppUrl(appUrl);
		this.id = new CompanyInfoId(id);
		this.companyName = companyName;
		this.businessRegistrationNumber = businessRegistrationNumber;
		this.coporationNumber = coporationNumber;
		this.nameOfRepresentative = nameOfRepresentative;
		this.establishmentDate = establishmentDate;
	}
	
	
}
