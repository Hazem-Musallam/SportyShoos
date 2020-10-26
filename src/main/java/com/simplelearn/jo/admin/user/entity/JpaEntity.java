package com.simplelearn.jo.admin.user.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public class JpaEntity {

	@CreatedDate
	@JsonIgnore
	@Column(name = "CREATION_DATE")
	private Instant creationDate;

	@Id
	@GeneratedValue
	@JsonIgnore
	@Column(name = "ID")
	private Long id;

	@LastModifiedDate
	@JsonIgnore
	@Column(name = "LAST_DATE")
	private Instant modificationDate;
}