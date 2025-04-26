package com.example.helper;

import com.example.dto.ProductDto;
import com.example.entities.Product;

public class ModelMapper {
	
	public static ProductDto productToProductdto(Product product) {
		if(product == null) {
			return null;
		}
		ProductDto dto = new ProductDto();
		dto.setId(product.getId());
		dto.setTitle(product.getTitle());
		dto.setCategory(product.getCategory());
		dto.setDescription(product.getDescription());
		dto.setImageUrl(product.getImageUrl());
		dto.setQuantity(product.getQuantity());
		dto.setLikes(product.getLikes());
		dto.setUnitPrice(product.getUnitPrice());
		return dto;
		
	}
	
	public static Product productdtoToProduct(ProductDto productDto) {
		if(productDto == null) {
			return null;
		}
		Product product = new Product();
		product.setCategory(productDto.getCategory());
		product.setDescription(productDto.getDescription());
		product.setId(productDto.getId());
		product.setImageUrl(productDto.getImageUrl());
		product.setLikes(productDto.getLikes());
		product.setQuantity(productDto.getQuantity());
		product.setTitle(productDto.getTitle());
		product.setUnitPrice(productDto.getUnitPrice());
		return product;
	}
	
}
