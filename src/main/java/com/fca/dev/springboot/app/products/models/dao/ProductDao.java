package com.fca.dev.springboot.app.products.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.fca.dev.springboot.app.commons.models.entity.Product;

public interface ProductDao extends CrudRepository<Product, Long> {
	

}
