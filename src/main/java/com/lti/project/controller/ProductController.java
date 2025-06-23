package com.lti.project.controller;

import com.lti.project.dto.ProductDto;
import com.lti.project.service.ProductService;
import com.lti.project.service.ProductServiceImpl;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {
    Logger logger = LogManager.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<ProductDto> addProduct(@Valid @RequestBody ProductDto productDto) {
        logger.info("ProductController:addProduct execution Started");
        ProductDto product = productService.saveProduct(productDto);
        return new ResponseEntity<ProductDto>(product, HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> fetchProducts(){
        List<ProductDto> products = productService.getProducts();
        return new ResponseEntity<Map<ProductDto>>(products, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> fetchProduct(@PathVariable("id") Integer productId){
        ProductDto product = productService.getProduct(productId);
        return new ResponseEntity<ProductDto>(product, HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Integer productId){
        productService.deleteProduct(productId);
        return new ResponseEntity<String>("Product deleted", HttpStatus.OK);
    }

}
