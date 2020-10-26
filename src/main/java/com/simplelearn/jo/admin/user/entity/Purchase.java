package com.simplelearn.jo.admin.user.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PURCHASE")
@Setter
@Getter
public class Purchase extends JpaEntity {
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "USER_ID")
	private User user;

	@Column(name = "INVOICE_ID")
	private String invoiceId;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "PRODUCTS_PURCHASE", joinColumns = @JoinColumn(name = "PURCHASE_ID"), inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
	private List<Products> products;

	@PrePersist
	void setDummyInvoice() {
		this.invoiceId = UUID.randomUUID().toString();
	}
}
