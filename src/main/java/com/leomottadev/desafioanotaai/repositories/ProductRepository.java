package com.leomottadev.desafioanotaai.repositories;

import com.leomottadev.desafioanotaai.domain.category.Category;
import com.leomottadev.desafioanotaai.domain.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}
