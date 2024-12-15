package com.lti.project.mapper;

import com.lti.project.dto.ProductDto;
import com.lti.project.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product mapProductDtoToProduct(ProductDto productDto);

    ProductDto mapProductToProductDto(Product product);

}
