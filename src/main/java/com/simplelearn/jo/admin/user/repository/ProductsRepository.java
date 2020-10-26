package com.simplelearn.jo.admin.user.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.simplelearn.jo.admin.user.entity.Products;

@Repository
public interface ProductsRepository extends PagingAndSortingRepository<Products, Long> {

	Page<Products> findAllByIsDeleted(boolean b, Pageable page);

}