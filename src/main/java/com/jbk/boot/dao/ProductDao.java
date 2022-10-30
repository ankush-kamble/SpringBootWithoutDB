package com.jbk.boot.dao;

import java.util.Arrays;
import java.util.List;

import com.jbk.boot.model.Product;

public interface ProductDao {
	
	public boolean saveProduct(Product product);
	
	public Product getProductById(int productId);
	
	public List<Product> getAllProduct();
	
	public boolean deleteProductbyId(int productId);
	
	public boolean updateProduct (Product product);
	
	
	
	
}
