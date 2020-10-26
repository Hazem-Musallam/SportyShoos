package com.simplelearn.jo.admin.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.simplelearn.jo.admin.user.entity.Products;
import com.simplelearn.jo.admin.user.repository.ProductsRepository;

@Service
public class ProductServices implements ProductServ {
	@Autowired
	private ProductsRepository productServices;

	@Override
	public Page<Products> findAll(Pageable page) {
		return productServices.findAll(page);
	}

	@Override
	public Products save(Products product) {
		return productServices.save(product);
	}

	@Override
	public void remove(Products product) {
		productServices.delete(product);
	}

	@Override
	public Products findById(Long id) {
		return productServices.findById(id).get();
	}

	@Override
	public Page<Products> findAllByIsDeleted(boolean b, Pageable page) {
		return productServices.findAllByIsDeleted(b, page);
	}

}
