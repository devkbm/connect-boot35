package com.like.core.envers;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@RevisionEntity
@Table(name = "REVINFO")
public class CustomRevisionEntity {

    @Id
    @Column(name = "REV_ID")
    @RevisionNumber
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
