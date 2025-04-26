package com.example.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.dto.ProductDto;

@Repository
public interface IProductRepository {
	//save given product (Insert)
	void save(ProductDto product);
	
	//Get all product
	List<ProductDto> getAll();
	
	//Get Product By Id
	ProductDto getById(int id);
	
	//Update by Id
	String updateById(int id, ProductDto updatedProduct);
	
	//delete By Id
	String deleteById(int id);
}
