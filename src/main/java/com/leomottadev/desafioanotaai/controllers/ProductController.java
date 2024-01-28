package com.leomottadev.desafioanotaai.controllers;

import com.leomottadev.desafioanotaai.domain.product.Product;
import com.leomottadev.desafioanotaai.domain.product.ProductDTO;
import com.leomottadev.desafioanotaai.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody ProductDTO productData) {
        Product newProduct = this.service.insert(productData);
        return ResponseEntity.ok(newProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        List<Product> products = this.service.getAll();
        return ResponseEntity.ok(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") String id, @RequestBody ProductDTO productData) {
        Product newProduct = this.service.update(id, productData);
        return ResponseEntity.ok().body(newProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable("id") String id) {
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
