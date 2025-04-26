package com.example.repositories;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.dto.ProductDto;
import com.example.entities.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ProductRepository implements IProductRepository{
	
	private final String FILE_PATH = "src/main/resources/products.json";
    private final ObjectMapper objectMapper = new ObjectMapper();
    
    private List<Product> products;
    
    public ProductRepository() {
		loadProducts();
	}
    
    private void loadProducts() {
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                products = objectMapper.readValue(file, new TypeReference<List<Product>>() {});
            } else {
                products = new ArrayList<>();
            }
        } catch (IOException e) {
            products = new ArrayList<>();
        }
    }
    
    private void saveProducts() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter()
                        .writeValue(new File(FILE_PATH), products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
	@Override
	public void save(Product product) {
		if(product != null) {
		    products.add(product);
		    saveProducts();
		}
	}

	@Override
	public List<Product> getAll() {
		return products;
	}

	@Override
	public Product getById(int id) {
		for (Product product : products) {
			if(product.getId() == id) {
				return product;
			}
		}
		return null;
	}

	@Override
	public boolean updateById(int id, Product updatedProduct) {
		for (int i = 0; i < products.size(); i++) {
			int productId = products.get(i).getId();
			System.out.println(productId);
	        if (productId == id) {
	        	updatedProduct.setId(productId);
	            products.set(i, updatedProduct);
	            saveProducts(); 
	            return true;
	        }
	    }
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		if(products.removeIf(product -> product.getId() == id)) {
			saveProducts();
			return true;
		}
		return false;
	}

}
