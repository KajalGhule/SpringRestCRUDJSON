package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.ProductDto;
import com.example.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public void save(ProductDto product) {
		productRepository.save(product);
	}
	public List<ProductDto> getAll() {
		return productRepository.getAll();
	}
	public ProductDto getById(int id) {
		return productRepository.getById(id);
	}
}
