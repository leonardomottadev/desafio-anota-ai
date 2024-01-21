package com.leomottadev.desafioanotaai.domain.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private String title;
    private String description;
    private String ownerID;
    private Integer price;
    private String categoryId;
}
