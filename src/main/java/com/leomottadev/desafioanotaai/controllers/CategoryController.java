package com.leomottadev.desafioanotaai.controllers;

import com.leomottadev.desafioanotaai.domain.category.Category;
import com.leomottadev.desafioanotaai.domain.category.CategoryDTO;
import com.leomottadev.desafioanotaai.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody CategoryDTO categoryData) {
        Category newCategory = this.service.insert(categoryData);
        return ResponseEntity.ok(newCategory);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        List<Category> categories = this.service.getAll();
        return ResponseEntity.ok(categories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable("id") String id, @RequestBody CategoryDTO categoryData) {
        Category newCategory = this.service.update(id, categoryData);
        return ResponseEntity.ok().body(newCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> delete(@PathVariable("id") String id) {
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
