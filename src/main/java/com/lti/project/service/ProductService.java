package com.lti.project.service;

import com.lti.project.dto.ProductDto;
import com.lti.project.entity.Product;

import java.util.List;

public interface ProductService {
    ProductDto saveProduct(ProductDto productDto);
    List<ProductDto> getProducts();
    ProductDto getProduct(int productId);
    void deleteProduct(int productId);
}
