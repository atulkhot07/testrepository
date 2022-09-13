package com.springboot.demo.mycoolapp.dao;

import java.util.List;

import com.springboot.demo.mycoolapp.entity.Category;

public interface CategoryDAO {

	Category getCategory(int categoryId);

	void saveCategory(Category theCategory);

	void deleteCategory(int categoryId);

	List<Category> findAll();

}
