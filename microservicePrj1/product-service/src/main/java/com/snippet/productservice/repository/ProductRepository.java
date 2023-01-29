package com.snippet.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.snippet.productservice.entity.ProductEntity;

@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, String>{

}
