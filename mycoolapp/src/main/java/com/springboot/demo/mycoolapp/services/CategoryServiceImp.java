package com.springboot.demo.mycoolapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.demo.mycoolapp.dao.CategoryDAO;
import com.springboot.demo.mycoolapp.entity.Category;

@Component
public class CategoryServiceImp implements CategoryService {
	
	@Autowired
	private CategoryDAO categoryDAO;

	@Override
	@Transactional
	public Category getCategory(int categoryId) {
		
		return categoryDAO.getCategory(categoryId);
	}

	@Override
	@Transactional
	public void saveCategory(Category theCategory) {
		categoryDAO.saveCategory(theCategory);

	}

	@Override
	@Transactional
	public void deleteCategory(int categoryId) {
		
		categoryDAO.deleteCategory(categoryId);

	}

}
