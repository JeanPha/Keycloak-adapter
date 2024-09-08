package com.product_service_manager.dto;

import lombok.Data;

@Data
public class ProductRequestDto {

    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private Long categoryId; 
    private String base64Image;

}