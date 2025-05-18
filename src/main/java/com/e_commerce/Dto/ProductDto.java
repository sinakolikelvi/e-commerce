package com.e_commerce.Dto;

import lombok.Data;

@Data
public class ProductDto {

    private String name;
    private String description;
    private Integer price;
    private Integer stockQuantity;
    private Long categoryId;
}
