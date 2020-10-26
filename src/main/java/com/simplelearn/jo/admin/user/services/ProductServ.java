package com.simplelearn.jo.admin.user.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.simplelearn.jo.admin.user.entity.Products;

public interface ProductServ {

	Page<Products> findAll(Pageable page);

	Products save(Products product);

	void remove(Products product);

	Products findById(Long key);

	Page<Products> findAllByIsDeleted(boolean b, Pageable page);

}
