package com.like.core.jpa.envers;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import io.hypersistence.utils.hibernate.id.Tsid;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@RevisionEntity
@Table(name = "REVINFO")
public class CustomRevisionEntity {

    @Id
    @Tsid
    @Column(name = "REV_ID")
    @RevisionNumber    
    Long revisionId;

    @Column(name = "REV_TS") 
    @RevisionTimestamp
    Long revisionTimeStamp;
    
    @Column (name = "REV_USER_ID")
    String revisionUserId;

    public LocalDateTime revisionTimeStamp() {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(revisionTimeStamp), ZoneId.systemDefault());
    }
    
    public void revisionUserId(String revisionUserId) {
    	this.revisionUserId = revisionUserId;
    }
}
