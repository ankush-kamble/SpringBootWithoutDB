package com.jbk.boot.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.apache.logging.log4j.util.ProcessIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.boot.dao.ProductDao;
import com.jbk.boot.model.Product;
import com.jbk.boot.sort.ProductNameComparator;
import com.jbk.boot.sort.ProductPriceComparator;
import com.jbk.boot.sort.ProductQtyComparator;
import com.jbk.boot.sort.ProductTypeComparator;
import com.jbk.boot.sort.ProductIDComparator;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;


	@Override
	public boolean saveProduct(Product product) {

		boolean isadded = dao.saveProduct(product);

		return isadded;
	}

	@Override
	public Product getProductById(int productId) {

		Product product = dao.getProductById(productId);

		return product;
	}

	@Override
	public List<Product> getAllProduct() {

		List<Product> list = dao.getAllProduct();
		return list;
	}

	@Override
	public boolean deleteProductbyId(int productId) {

		boolean isDeleted = dao.deleteProductbyId(productId);
		return isDeleted;
	}

	@Override
	public boolean updateProduct(Product product) {
		boolean isUpdated = dao.updateProduct(product);
		return isUpdated;
	}

	@Override
	public List<Product> sortProduct(String sortBy) {

		List<Product> list = getAllProduct();
		if (sortBy.equalsIgnoreCase("productName")) {
			Collections.sort(list, new ProductNameComparator());

		} else if (sortBy.equalsIgnoreCase("productId")) {
			Collections.sort(list, new ProductIDComparator());

		} else if (sortBy.equalsIgnoreCase("productPrice")) {
			Collections.sort(list, new ProductPriceComparator());
			
		} else if (sortBy.equalsIgnoreCase("productQty")) {
			Collections.sort(list, new ProductQtyComparator());
			
		} else if (sortBy.equalsIgnoreCase("productType")) {
			Collections.sort(list, new ProductTypeComparator());
		}
		return list;
	}
	
	
	@Override
	public int getTotalCountofProducts() {
		List<Product>list=dao.getAllProduct();
		int productCount=list.size();
		return productCount;
		}

	@Override
	public double getSumofProductprice() {

		List<Product> list=getAllProduct();
		Stream<Product> stream=list.stream();
		Stream<Double> stream2=stream.map(product-> product.getProductPrice());
		Optional<Double> optional=stream2.reduce((price1,price2)->price1+ price2);
		double sumProductPrice=optional.get();
		return sumProductPrice;
	}

	@Override
	public Product getMaxProductDetails() {
		Product product = null;
		List<Product>list=getAllProduct();
		
		Stream<Product>stream=list.stream();
		Optional<Product> optional=stream.max(new ProductPriceComparator());
		
		if(optional.isPresent()) {
			product = optional.get();
		}
		
		return product;
	}

	@Override
	public Product getMaxProductDetails_2() {
		Product product = null;
		List<Product>list=sortProduct_Desc("productPrice");
		product=list.get(0);
		
		return product;
	}

	@Override
	public List<Product> sortProduct_Desc(String sortBy) {
		List<Product>list=sortProduct(sortBy);
		Collections.reverse(list);
		
		return list;
	}

	@Override
	public Product getMaxProductDetails_3() {
		List<Product>list=dao.getAllProduct();
		Product maxProduct = list.get(0);
		double maxPrice=maxProduct.getProductPrice();
		
		for(Product product:list) {
			
			if(product.getProductPrice()>maxPrice) {
				maxProduct=product;
				maxPrice= product.getProductPrice();
			}
		}
		return maxProduct;
	}
	
	@Override
	public double getMaxProductvalue() {
	List<Product> list=getAllProduct();
	Stream<Product> stream=list.stream();
	Optional<Double> optional=stream.map((product)-> product.getProductPrice()).max((product1,product2) -> product1.compareTo(product2));
	double maxProduct=optional.get();
		return maxProduct;
	}
	

	
}
