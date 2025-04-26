package com.example.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.dto.ProductDto;
import com.example.entities.Product;

@Repository
public interface IProductRepository {
	//save given product (Insert)
	void save(Product product);
	
	//Get all product
	List<Product> getAll();
	
	//Get Product By Id
	Product getById(int id);
	
	//Update by Id
	boolean updateById(int id, Product updatedProduct);
	
	//delete By Id
	boolean deleteById(int id);
}
