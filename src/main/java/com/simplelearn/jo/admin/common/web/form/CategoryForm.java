package com.simplelearn.jo.admin.common.web.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryForm {
	private String categoryName;
	private Long id;

}