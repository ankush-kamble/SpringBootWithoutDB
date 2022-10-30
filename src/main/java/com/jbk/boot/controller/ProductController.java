package com.jbk.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.boot.model.Product;
import com.jbk.boot.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService service;

	@PostMapping(value = "/saveProduct")
	public boolean saveProduct(@RequestBody Product product) {

		System.out.println(product);
		boolean isadded = service.saveProduct(product);

		return isadded;

	}

	@GetMapping(value = "/getAllProduct")
	public List<Product> getAllProduct() {

		List<Product> list = service.getAllProduct();
		return list;

	}

	@GetMapping(value = "/getproductbyId")
	public Product getProductById(@RequestParam int productId) {
		Product product = service.getProductById(productId);
		return product;

	}

	@DeleteMapping(value = "/deleteProductbyId")
	public boolean deleteProductbyId(int productId) {
		boolean isDeleted = service.deleteProductbyId(productId);
		return isDeleted;

	}

	@PutMapping(value = "/updateProduct")
	public boolean updateProduct(@RequestBody Product product) {
		boolean isUpdated = service.updateProduct(product);
		return isUpdated;

	}

	@GetMapping(value = "/sortProduct")
	public List<Product> sortProduct(@RequestParam String sortBy) {
		List<Product> list = service.sortProduct(sortBy);
		return list;
	}

	@GetMapping(value = "/maxProduct")
	public double getMaxProduct() {
		double maxProduct = service.getMaxProductvalue();
		return maxProduct;
	}

	@GetMapping(value = "/productCount")
	public int getTotalCountofProducts() {
		int productCount = service.getTotalCountofProducts();
		return productCount;
	}

	@GetMapping(value = "/sumProductPrice")
	public double getSumofProductprice() {
		double sumProductPrice = service.getSumofProductprice();
		return sumProductPrice;
	}

	@GetMapping(value="/getMaxProduct")
	public Product getMaxProductDetails() {
		//Product product=service.getMaxProductDetails();
		
		Product product=service.getMaxProductDetails_3();
		
		return product;
	}
}
