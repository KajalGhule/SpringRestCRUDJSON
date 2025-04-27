package com.example.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.ProductDto;
import com.example.entities.Product;
import com.example.helper.ModelMapper;
import com.example.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	/*
	 * Before send product data to repo layer we need to conver it
	 * to ProductDto to product 
	 * so we add one helper layer were we can convert product dto to product and product to productdto
	 * before return to controller
	 * */
	public void save(ProductDto product) { 
		Product p = ModelMapper.productdtoToProduct(product);
		productRepository.save(p);
	}
	
	public List<ProductDto> getAll(){
		List<Product> products = productRepository.getAll();
	    return products.stream()
	                   .map(ModelMapper::productToProductdto)
	                   .collect(Collectors.toList());
	}
	public ProductDto getById(int id) {
		Product p = productRepository.getById(id);
		ProductDto product = ModelMapper.productToProductdto(p);
		return product;
	}
	public boolean updateById(int id, ProductDto updatedProduct) {
		Product product = ModelMapper.productdtoToProduct(updatedProduct);
		return productRepository.updateById(id, product);
	}
	public boolean deleteById(int id) {
		return productRepository.deleteById(id);
	}
}
