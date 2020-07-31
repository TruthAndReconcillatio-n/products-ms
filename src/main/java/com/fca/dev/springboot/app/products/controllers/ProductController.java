package com.fca.dev.springboot.app.products.controllers;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fca.dev.springboot.app.products.models.entity.Product;
import com.fca.dev.springboot.app.products.models.service.IProductService;

@RestController
public class ProductController {
	
	@Autowired
	private Environment env;
	@Autowired
	private IProductService productService;

	@GetMapping("/ver")
	public List<Product> listar() {
		
		return productService.findAll().stream().map(product -> {
			product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			return product;
			}).collect(Collectors.toList());
	}
	
	@GetMapping("/ver/{id}")
	public Product detalle(@PathVariable Long id) {
		Product product = productService.findById(id);
		product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return product;
	}
}
