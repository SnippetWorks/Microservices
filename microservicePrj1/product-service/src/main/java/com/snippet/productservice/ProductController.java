package com.snippet.productservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.snippet.productservice.entity.ProductEntity;
import com.snippet.productservice.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	@GetMapping
	public ResponseEntity<List<ProductEntity>> getAllProducts() {

		List<ProductEntity> pe = productRepository.findAll();
		ResponseEntity<List<ProductEntity>> re = new ResponseEntity<>(pe, HttpStatus.OK);

		return re;

	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody ProductEntity productEntity) {
		productRepository.save(productEntity);
	}

}
