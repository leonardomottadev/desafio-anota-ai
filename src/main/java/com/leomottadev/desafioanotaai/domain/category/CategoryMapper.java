package com.leomottadev.desafioanotaai.domain.category;

public class CategoryMapper {
    public static CategoryDTO toDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setTitle(category.getTitle());
        categoryDTO.setDescription(category.getDescription());
        categoryDTO.setOwnerId(category.getOwnerId());
        return categoryDTO;
    }

    public static Category toEntity(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setTitle(categoryDTO.getTitle());
        category.setDescription(categoryDTO.getDescription());
        category.setOwnerId(categoryDTO.getOwnerId());
        return category;
    }

    public Category dataToCategory(Category category, CategoryDTO categoryData) {
        if(!categoryData.getTitle().isEmpty()) {
            category.setTitle(categoryData.getTitle());
        }
        if(!categoryData.getDescription().isEmpty()) {
            category.setDescription(categoryData.getDescription());
        }
        return category;
    }
}
