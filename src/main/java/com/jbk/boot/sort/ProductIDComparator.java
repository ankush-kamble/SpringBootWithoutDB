package com.jbk.boot.sort;

import java.util.Comparator;

import com.jbk.boot.model.Product;

public class ProductIDComparator implements Comparator<Product>{

	@Override
	public int compare(Product p1, Product p2) {
	
		if (p1.getProductId()==p2.getProductId()) {
			return 0;
		} else if (p1.getProductId()>p2.getProductId()) {
			return 1;
		} else {
			return -1;
		}
	}

}
