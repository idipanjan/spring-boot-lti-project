package com.lti.project.service;

import com.lti.project.dto.ProductDto;
import com.lti.project.entity.Product;
import com.lti.project.exception.ResourceNotFoundException;
import com.lti.project.mapper.ProductMapper;
import com.lti.project.repository.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    Logger logger = LogManager.getLogger(ProductServiceImpl.class);

    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        logger.info("ProductService:saveProduct execution Started");
        Product product = ProductMapper.INSTANCE.mapProductDtoToProduct(productDto);
        Product newProduct = productRepository.save(product);
        logger.info("ProductService:saveProduct execution Ended");
        return ProductMapper.INSTANCE.mapProductToProductDto(newProduct);
    }

    @Override
    public List<ProductDto> getProducts() {
        logger.info("ProductService:getProducts execution Started");
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = products
                                            .stream()
                                            .map(product -> ProductMapper.INSTANCE.mapProductToProductDto(product))
                                            .collect(Collectors.toList());
        logger.info("ProductService:getProducts execution ended");
        return productDtos;
    }

    @Override
    public ProductDto getProduct(int productId) {
        logger.info("ProductService:getProduct execution Started...");
        Product product = productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("product not found with Id: "+productId));
        logger.info("ProductService:getProduct execution Ended...");
        return ProductMapper.INSTANCE.mapProductToProductDto(product);
    }

    @Override
    public void deleteProduct(int productId) {
        Product product = productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("product not found with Id: "+productId));
        productRepository.delete(product);
    }
}
