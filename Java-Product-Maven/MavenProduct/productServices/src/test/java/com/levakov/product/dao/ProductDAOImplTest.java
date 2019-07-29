package com.levakov.product.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.levakov.product.dto.Product;

public class ProductDAOImplTest {

	@Test
	public void createShouldCreateAProduct() {

		ProductDAO dao = new ProductDAOImpl();
		Product product = new Product();
		
		product.setId(1);
		product.setName("Nokia");
		product.setDescription("It's Amazing !");
		product.setPrice(250);
		
		dao.create(product);
		
		Product result = dao.read(1);
		
		assertNotNull(result);
		assertEquals("Nokia", result.getName());
	}

}
