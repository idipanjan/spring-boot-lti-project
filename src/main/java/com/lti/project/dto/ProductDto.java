package com.lti.project.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private long id;
    @NotBlank(message = "Product name is required")
    private String name;
    @Min(value=1, message="Quantity must be greater than zero")
    private int quantity;
    @Min(value=1, message="Price must be greater than zero")
    private int price;
    private String description;

}
