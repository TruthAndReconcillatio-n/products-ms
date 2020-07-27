package com.fca.dev.springboot.app.products.models.service;

import java.util.List;

import com.fca.dev.springboot.app.products.models.entity.Product;

public interface IProductService {

	public List<Product> findAll();
	public Product findById(Long id);
}