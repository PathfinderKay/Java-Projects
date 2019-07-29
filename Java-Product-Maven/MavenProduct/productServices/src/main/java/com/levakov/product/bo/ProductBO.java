package com.levakov.product.bo;

import com.levakov.product.dto.Product;

public interface ProductBO {

	public void create(Product product);
	
	public Product findProduct(int id);
	
}
