package com.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.mycoolapp.entity.Category;
import com.springboot.demo.mycoolapp.services.CategoryService;


@RestController
@RequestMapping("/api")
public class CategoryRestController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	@GetMapping("/categories/{categoryId}")
	public Category getCustomer(@PathVariable int categoryId) throws CategoryNotFoundException {
		
		Category theCategory = categoryService.getCategory(categoryId);
		
		if (theCategory == null) {
			throw new CategoryNotFoundException("Category id not found - " + categoryId);
		}
		
		return theCategory;
	}
	
	
	
	@PostMapping("/categories")
	public Category addCategory(@RequestBody Category theCategory) {
		
		
		theCategory.setId(0);
		
		categoryService.saveCategory(theCategory);
		
		return theCategory;
	}
	
	
	@PutMapping("/categories")
	public Category updateCategory(@RequestBody Category theCategory) {
		
		categoryService.saveCategory(theCategory);
		
		return theCategory;
		
	}
	
	
	@DeleteMapping("/categories/{CategoryId}")
	public String deleteCategory(@PathVariable int categoryId) throws CategoryNotFoundException {
		
		Category tempCategory = categoryService.getCategory(categoryId);
		
		// throw exception if null
		
		if (tempCategory == null) {
			throw new CategoryNotFoundException("Customer id not found - " + categoryId);
		}
				
		categoryService.deleteCategory(categoryId);
		
		return "Deleted category id - " + categoryId;
	}

}
