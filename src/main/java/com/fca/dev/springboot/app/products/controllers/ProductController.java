package com.fca.dev.springboot.app.products.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fca.dev.springboot.app.products.models.entity.Product;
import com.fca.dev.springboot.app.products.models.service.IProductService;

@RestController
public class ProductController {

	@Autowired
	private IProductService productService;

	@GetMapping("/ver")
	public List<Product> listar() {
		return productService.findAll();
	}
	
	@GetMapping("/ver/{id}")
	public Product detalle(@PathVariable Long id) {
		return productService.findById(id);
	}
}
