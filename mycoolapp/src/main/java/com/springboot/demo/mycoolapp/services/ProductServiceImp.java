package com.springboot.demo.mycoolapp.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.springboot.demo.mycoolapp.dao.ProductDAO;
import com.springboot.demo.mycoolapp.dao.ProductJPARepo;
import com.springboot.demo.mycoolapp.entity.Product;

@Service
public class ProductServiceImp implements ProductService {
	
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ProductJPARepo productJPARepo;
	
	@Override
	@Transactional
	public List<Product> findAllProducts() {
		return productDAO.findAll();
	}
	
	@Override
    public Page<Product> findPaginated(int pageNo, int pageSize) {

        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Product> pagedResult = productJPARepo.findAll(paging);

        return pagedResult;
    }
	


	@Override
	@Transactional
	public Product getProduct(int productId) {
		
		
		return productDAO.getProduct(productId);
	}

	@Override
	@Transactional
	public void saveProduct(Product theCustomer) {
		productDAO.saveProduct(theCustomer);

	}

	@Override
	@Transactional
	public void deleteProduct(int productId) {
		productDAO.deleteProduct(productId);
	}

}
