package com.springboot.demo.mycoolapp.rest;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.demo.mycoolapp.entity.Product;
import com.springboot.demo.mycoolapp.services.ProductService;



@RestController
@RequestMapping("/api")
public class ProductRestController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public List<Product> findAllPrducts() {
		return productService.findAllProducts();
	}
	
	 @GetMapping("/productspaginated/{pageNo}/{pageSize}")
	    public Page <Product> getPaginatedCountries(@PathVariable int pageNo, 
	            @PathVariable int pageSize) {

	        return productService.findPaginated(pageNo, pageSize);
	    } 
	
	@GetMapping("/products/{productId}")
	public Product getProduct(@PathVariable int productId) throws ProductNotFoundException {
		
		Product theProduct = productService.getProduct(productId);
		
		if (theProduct == null) {
			throw new ProductNotFoundException("Product id not found - " + productId);
		}
		
		return theProduct;
	}
	

	
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product theProduct) {
		
		theProduct.setId(0);
		
		productService.saveProduct(theProduct);
		
		return theProduct;
	}
	
	@PutMapping("/products")
	public Product updateCustomer(@RequestBody Product theProduct) {
		
		productService.saveProduct(theProduct);
		
		return theProduct;
		
	}
	
	
	
	@DeleteMapping("/products/{productId}")
	public String deleteProduct(@PathVariable int productId) throws ProductNotFoundException {
		
		Product tempProduct = productService.getProduct(productId);
		
		// throw exception if null
		
		if (tempProduct == null) {
			throw new ProductNotFoundException("Product id not found - " + productId);
		}
				
		productService.deleteProduct(productId);
		
		return "Deleted product id - " + productId;
	}

}
