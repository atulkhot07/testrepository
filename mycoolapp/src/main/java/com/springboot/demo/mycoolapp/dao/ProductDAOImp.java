package com.springboot.demo.mycoolapp.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.springboot.demo.mycoolapp.entity.Product;

@Repository
public class ProductDAOImp implements ProductDAO {

		private EntityManager entityManager;
		
		@Autowired
		public ProductDAOImp(EntityManager theEntityManager) {
			entityManager = theEntityManager;
		}
		
		
		
		@Override
		public List<Product> findAll() {

					Query theQuery = entityManager.createQuery("from Product");
			
					List<Product> products  = theQuery.getResultList();
			
					return products;
		}
	
	
	@Override
	public Product getProduct(int productId) {
		Product theProducty = 
				entityManager.find(Product.class, productId);
		
		return theProducty;
	}

	@Override
	public void saveProduct(Product theProduct) {
		Product dbProduct = entityManager.merge(theProduct);
		
		theProduct.setId(dbProduct.getId());
	}

	@Override
	public void deleteProduct(int productId) {
		Query theQuery = entityManager.createQuery(
				"delete from Product where id=:productId");

				theQuery.setParameter("productId", productId);
				theQuery.executeUpdate();
	}



}
