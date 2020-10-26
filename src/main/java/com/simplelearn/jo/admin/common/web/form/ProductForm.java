package com.simplelearn.jo.admin.common.web.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductForm {
	private String productName;
	private Double price;
	private Long id;
	private Long category;

}