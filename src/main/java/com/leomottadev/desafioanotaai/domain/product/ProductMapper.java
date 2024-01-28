package com.leomottadev.desafioanotaai.domain.product;

public class ProductMapper {
    public static ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setTitle(product.getTitle());
        productDTO.setDescription(product.getDescription());
        productDTO.setOwnerID(product.getOwnerId());
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }

    public static Product toEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setTitle(productDTO.getTitle());
        product.setDescription(productDTO.getDescription());
        product.setOwnerId(productDTO.getOwnerID());
        product.setPrice(productDTO.getPrice());
        return product;
    }

    public Product dataToProduct(Product product, ProductDTO productData) {
        if(!productData.getTitle().isEmpty()) {
            product.setTitle(productData.getTitle());
        }
        if(!productData.getDescription().isEmpty()) {
            product.setDescription(productData.getDescription());
        }
        if(productData.getPrice() != null) {
            product.setPrice(productData.getPrice());
        }
        if(productData.getCategoryId() != null) {
            product.setCategory(productData.getCategoryId());
        }
        return product;
    }
}
