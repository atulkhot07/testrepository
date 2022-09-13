package com.springboot.demo.mycoolapp.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.springboot.demo.mycoolapp.entity.Product;

public interface ProductService {

	public Product getProduct(int productId);

	public void saveProduct(Product theCustomer) ;

	public void deleteProduct(int productId);

	public List<Product> findAllProducts();
	
	Page<Product> findPaginated(int pageNo, int pageSize);

}
