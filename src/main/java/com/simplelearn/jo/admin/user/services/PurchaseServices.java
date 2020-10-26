package com.simplelearn.jo.admin.user.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.simplelearn.jo.admin.user.entity.Categories;
import com.simplelearn.jo.admin.user.entity.Purchase;
import com.simplelearn.jo.admin.user.repository.PurchaseRepository;

@Service
public class PurchaseServices implements PurchaseServ {
	@Autowired
	private PurchaseRepository productServices;
	@Autowired
	private CategoriesServ catService;

	@Override
	public Page<Purchase> findAll(Pageable page) {
		return productServices.findAll(page);
	}

	@Override
	public Purchase save(Purchase product) {
		return productServices.save(product);
	}

	@Override
	public void remove(Purchase product) {
		productServices.delete(product);
	}

	@Override
	public Purchase findById(Long id) {
		return productServices.findById(id).get();
	}

	@Override
	public Page<Purchase> findSearch(Instant instant, String category, Pageable page) {
		Categories findByCategoryName = null;
		if (category != null && !category.isEmpty()) {
			findByCategoryName = catService.findByCategoryName(category);
		}

		if (instant == null && findByCategoryName == null) {
			return productServices.findAll(page);
		} else if (instant == null && findByCategoryName != null) {
			return productServices.findByProductsCategories(findByCategoryName, page);
		} else if (instant != null && findByCategoryName == null) {
			return productServices.findByCreationDateGreaterThanEqual(instant, page);
		}

		return productServices.findByCreationDateGreaterThanEqualOrProductsCategories(instant, findByCategoryName,
				page);
	}

}
