package com.jbk.boot.sort;

import java.util.Comparator;

import com.jbk.boot.model.Product;

public class ProductTypeComparator implements Comparator<Product>{

	@Override
	public int compare(Product p1, Product p2) {
		
		return p1.getProductType().compareTo(p2.getProductType());
	}

}
