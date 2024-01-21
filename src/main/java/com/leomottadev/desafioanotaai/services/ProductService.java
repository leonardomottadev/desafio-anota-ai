package com.leomottadev.desafioanotaai.services;

import com.leomottadev.desafioanotaai.domain.category.Category;
import com.leomottadev.desafioanotaai.domain.product.Product;
import com.leomottadev.desafioanotaai.domain.product.ProductDTO;
import com.leomottadev.desafioanotaai.domain.product.ProductMapper;
import com.leomottadev.desafioanotaai.domain.product.exceptions.ProductNotFoundException;
import com.leomottadev.desafioanotaai.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository repository;
    private CategoryService categoryService;

    public ProductService(ProductRepository repository, CategoryService categoryService) {
        this.repository = repository;
        this.categoryService = categoryService;
    }

    public List<Product> getAll() {
        return this.repository.findAll();
    }

    public Product insert(ProductDTO productData) {
        Category category = this.categoryService.getById(productData.getCategoryId())
                .orElseThrow(ProductNotFoundException::new);
        Product newProduct = new ProductMapper().toEntity(productData);
        newProduct.setCategory(category);
        this.repository.save(newProduct);
        return newProduct;
    }

    public Product update(String id, ProductDTO productData) {
        Product product = this.repository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
        if(productData.getCategoryId() != null) {
            this.categoryService.getById(productData.getCategoryId())
                    .ifPresent(product::setCategory);
        }
        new ProductMapper().dataToProduct(product, productData);
        this.repository.save(product);
        return product;
    }

    public void delete(String id) {
        Product product = this.repository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
        this.repository.delete(product);
    }
}
