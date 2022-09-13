package com.springboot.demo.mycoolapp.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springboot.demo.mycoolapp.entity.Product;

public interface ProductDAO {

	Product getProduct(int productId);

	void saveProduct(Product theProduct);

	void deleteProduct(int productId);

	public List<Product> findAll();

}
