package com.simplelearn.jo.admin.user.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;

import com.simplelearn.jo.admin.data.Previliges;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Privilege extends JpaEntity {
	@Enumerated(EnumType.STRING)
	private Previliges name;

	@ManyToMany(mappedBy = "privileges")
	private Collection<Role> roles;
}