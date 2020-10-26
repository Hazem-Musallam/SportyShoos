package com.simplelearn.jo.admin.user.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PRODUCTS")
@Setter
@Getter
@SQLDelete(sql = "update PRODUCTS set IS_DELETED=true where ID=? ")
public class Products extends JpaEntity {

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "PRODUCT_PRICE")
	private Double price;

	@ManyToMany(mappedBy = "products")
	private List<Purchase> purchases;

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "PRODUCTS_CATEGORIES", joinColumns = @JoinColumn(name = "PRODUCT_ID"), inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID"))
	private List<Categories> categories = new ArrayList<Categories>();

	@Column(name = "IS_DELETED")
	private boolean isDeleted;
}
