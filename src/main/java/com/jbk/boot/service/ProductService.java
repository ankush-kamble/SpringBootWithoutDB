package com.jbk.boot.service;

import java.util.List;

import com.jbk.boot.model.Product;

public interface ProductService {

	public boolean saveProduct(Product product);
	
	public Product getProductById(int productId);
	
	public List<Product> getAllProduct();
	
	public boolean deleteProductbyId(int productId);
	
	public boolean updateProduct (Product product);
	
	public List<Product> sortProduct(String sortBy);
	
	public List<Product> sortProduct_Desc(String sortBy);
	

	
	public int getTotalCountofProducts() ;
	
	public double getSumofProductprice();
	
	public Product getMaxProductDetails();
	
	public Product getMaxProductDetails_2();
	
	public Product getMaxProductDetails_3();

	public double getMaxProductvalue();

}
