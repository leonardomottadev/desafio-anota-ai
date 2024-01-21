package com.leomottadev.desafioanotaai.services;

import com.leomottadev.desafioanotaai.domain.category.Category;
import com.leomottadev.desafioanotaai.domain.category.CategoryDTO;
import com.leomottadev.desafioanotaai.domain.category.CategoryMapper;
import com.leomottadev.desafioanotaai.domain.category.exceptions.CategoryNotFoundException;
import com.leomottadev.desafioanotaai.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Optional<Category> getById(String id) {
        return this.repository.findById(id);
    }

    public List<Category> getAll() {
        return this.repository.findAll();
    }

    public Category insert(CategoryDTO categoryData) {
        Category newCategory = new CategoryMapper().toEntity(categoryData);
        this.repository.save(newCategory);
        return newCategory;
    }

    public Category update(String id, CategoryDTO categoryData) {
        Category category = this.repository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);
        category = new CategoryMapper().dataToCategory(category, categoryData);
        this.repository.save(category);
        return category;
    }

    public void delete(String id) {
        Category category = this.repository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);
        this.repository.delete(category);
    }

}
