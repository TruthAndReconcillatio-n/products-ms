package com.fca.dev.springboot.app.products.controllers;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fca.dev.springboot.app.products.models.entity.Product;
import com.fca.dev.springboot.app.products.models.service.IProductService;

@RestController
public class ProductController {
	
	@Value("${server.port}")
	private Integer port;
	
	@Autowired
	private Environment env;
	@Autowired
	private IProductService productService;

	@GetMapping("/ver")
	public List<Product> listar() {
		
		return productService.findAll().stream().map(product -> {
			product.setPort(port);
			return product;
			}).collect(Collectors.toList());
	}
	
	@GetMapping("/ver/{id}")
	public Product detalle(@PathVariable Long id){
		Product product = productService.findById(id);
		product.setPort(port);
//		try {
//			Thread.sleep(2000L);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		return product;
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Product create(@RequestBody Product product) {
		return productService.save(product);
	}
	
	@PutMapping("/edit/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Product edit(@RequestBody Product product, @PathVariable Long id) {
		Product productDB = productService.findById(id);
		productDB.setName(product.getName());
		productDB.setPrice(product.getPrice());
		return productService.save(productDB);		
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		productService.deleteById(id);
	}
}
