package com.jbk.boot.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.jbk.boot.model.Product;
import com.jbk.boot.sort.ProductNameComparator;

@Repository
public class ProductDaoImpl implements ProductDao {

	
	List<Product> list= new ArrayList<>();
	
	public ProductDaoImpl() {
		list.add(new Product(1,"Redmi",7,15000,"Mobiles"));
		list.add(new Product(2,"Realme",5,16000,"Mobiles"));
		list.add(new Product(3,"Google Pixel",2,55000,"Mobiles"));
		list.add(new Product(4,"Samsung",4,25000,"Mobiles"));
		list.add(new Product(5,"Oppo",8,17000,"Mobiles"));
		list.add(new Product(6,"Vivo",10,16000,"Mobiles"));
		list.add(new Product(7,"Realme TV",14,1000,"Electronics"));
		list.add(new Product(8,"Redmi TV",14,1000,"Electronics"));
		list.add(new Product(9,"Sony TV",14,1000,"Electronicses"));
		list.add(new Product(10,"Samsung TV",14,1000,"Electronics"));
	}
	@Override
	public boolean saveProduct( Product product ) {
		list.add(product);
		
		return true;
	}

	@Override
	public Product getProductById(int productId) {
		
		Product product=null;
		for (Product prd : list) {
			if (prd.getProductId()==productId) {
				product=prd;
			}
		}
		return product;
	}

	@Override
	public List<Product> getAllProduct() {
	
		return list;
	}

	@Override
	public boolean deleteProductbyId(int productId) {
		
	boolean isDeleted=false;
		for (Product prd : list) {
			if (prd.getProductId()==productId) {
					list.remove(prd);
					isDeleted=true;
					break;
			}
		}
		return true;
	}
	@Override
	public boolean updateProduct(Product product) {
		boolean isUpdated=false;
		for (Product prd : list) {
			if (prd.getProductId()== product.getProductId()) {
				list.remove(prd);
				list.add(product);
				isUpdated=true;
				break;
			}
		}
		return isUpdated;
	}
	
	
	
	

	
	
}
