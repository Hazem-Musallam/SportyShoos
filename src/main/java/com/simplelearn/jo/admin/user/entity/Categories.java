package com.simplelearn.jo.admin.user.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CATEGORIES")
@Setter
@Getter
@SQLDelete(sql = "update CATEGORIES set IS_DELETED=true where ID=? ")
public class Categories extends JpaEntity {

	@Column(name = "CATEGORY_NAME")
	private String categoryName;

	@ManyToMany(mappedBy = "categories")
	private List<Products> products;

	@Column(name = "IS_DELETED")
	private boolean isDeleted;
}
