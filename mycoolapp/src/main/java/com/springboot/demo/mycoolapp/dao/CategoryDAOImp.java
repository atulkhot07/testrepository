package com.springboot.demo.mycoolapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.demo.mycoolapp.entity.Category;

@Repository
public class CategoryDAOImp implements CategoryDAO {

	
	private EntityManager entityManager;
	
	@Autowired
	public CategoryDAOImp(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Category> findAll() {

				Query theQuery = entityManager.createQuery("from Category");
		
				List<Category> categories  = theQuery.getResultList();
		
				return categories;
	}
	
	@Override
	public Category getCategory(int categoryId) {
		
		Category theCategory = 
						entityManager.find(Category.class, categoryId);
				
				return theCategory;
	}

	@Override
	public void saveCategory(Category theCategory) {
		
		Category dbCategory = entityManager.merge(theCategory);
				
				
		theCategory.setId(dbCategory.getId());
	}

	@Override
	public void deleteCategory(int categoryId) {
		
		Query theQuery = entityManager.createQuery(
				"delete from Category where id=:categoryId");

				theQuery.setParameter("categoryId", categoryId);

				theQuery.executeUpdate();

	}

}
