package com.simplelearn.jo.admin.user.services;

import java.time.Instant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.simplelearn.jo.admin.user.entity.Purchase;

public interface PurchaseServ {

	Page<Purchase> findAll(Pageable page);

	Purchase save(Purchase product);

	void remove(Purchase product);

	Purchase findById(Long key);

	Page<Purchase> findSearch(Instant instant, String category, Pageable page);

}
