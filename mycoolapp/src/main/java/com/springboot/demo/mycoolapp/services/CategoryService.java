package com.springboot.demo.mycoolapp.services;

import com.springboot.demo.mycoolapp.entity.Category;

public interface CategoryService {

	Category getCategory(int categoryId);

	void saveCategory(Category theCategory);

	void deleteCategory(int categoryId);

}
