package com.springboot.demo.mycoolapp.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springboot.demo.mycoolapp.entity.Product;

public interface ProductJPARepo extends PagingAndSortingRepository<Product, Integer> {

	
	
}
