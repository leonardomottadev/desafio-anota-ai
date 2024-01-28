package com.leomottadev.desafioanotaai.services;

import com.leomottadev.desafioanotaai.domain.category.Category;
import com.leomottadev.desafioanotaai.domain.category.exceptions.CategoryNotFoundException;
import com.leomottadev.desafioanotaai.domain.product.Product;
import com.leomottadev.desafioanotaai.domain.product.ProductDTO;
import com.leomottadev.desafioanotaai.domain.product.ProductMapper;
import com.leomottadev.desafioanotaai.domain.product.exceptions.ProductNotFoundException;
import com.leomottadev.desafioanotaai.repositories.ProductRepository;
import com.leomottadev.desafioanotaai.services.aws.AwsSnsService;
import com.leomottadev.desafioanotaai.services.aws.MessageDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;
    private final CategoryService categoryService;
    private final AwsSnsService snsService;

    public ProductService(ProductRepository repository, CategoryService categoryService, AwsSnsService snsService) {
        this.repository = repository;
        this.categoryService = categoryService;
        this.snsService = snsService;
    }

    public List<Product> getAll() {
        return this.repository.findAll();
    }

    public Product insert(ProductDTO productData) {
        this.categoryService.getById(productData.getCategoryId())
                .orElseThrow(ProductNotFoundException::new);
        Product newProduct = new ProductMapper().toEntity(productData);
        this.repository.save(newProduct);
        this.snsService.publish(new MessageDTO(newProduct.toString()));
        return newProduct;
    }

    public Product update(String id, ProductDTO productData) {
        Product product = this.repository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
        if(productData.getCategoryId() != null) {
            this.categoryService.getById(productData.getCategoryId())
                    .orElseThrow(CategoryNotFoundException::new);
        }
        new ProductMapper().dataToProduct(product, productData);
        this.repository.save(product);
        this.snsService.publish(new MessageDTO(product.toString()));
        return product;
    }

    public void delete(String id) {
        Product product = this.repository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
        this.repository.delete(product);
    }
}
