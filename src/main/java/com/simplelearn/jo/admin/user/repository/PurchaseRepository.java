package com.simplelearn.jo.admin.user.repository;

import java.time.Instant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.simplelearn.jo.admin.user.entity.Categories;
import com.simplelearn.jo.admin.user.entity.Purchase;

@Repository
public interface PurchaseRepository extends PagingAndSortingRepository<Purchase, Long> {

	Page<Purchase> findByCreationDateGreaterThanEqualOrProductsCategoriesCategoryNameIgnoreCase(Instant instant,
			String category, Pageable page);

	Page<Purchase> findByProductsCategoriesCategoryName(String category, Pageable page);

	Page<Purchase> findByCreationDateGreaterThanEqual(Instant instant, Pageable page);

	Page<Purchase> findByProductsCategories(Categories findByCategoryName, Pageable page);

	Page<Purchase> findByCreationDateGreaterThanEqualOrProductsCategories(Instant instant,
			Categories findByCategoryName, Pageable page);

}