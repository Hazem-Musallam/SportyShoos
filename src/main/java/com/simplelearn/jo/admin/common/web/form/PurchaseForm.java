package com.simplelearn.jo.admin.common.web.form;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseForm {
	private Map<Long, Boolean> item;

}