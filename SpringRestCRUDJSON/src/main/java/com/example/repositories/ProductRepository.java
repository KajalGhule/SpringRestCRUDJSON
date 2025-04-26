package com.example.repositories;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.dto.ProductDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ProductRepository implements IProductRepository{
	
	private final String FILE_PATH = "src/main/resources/products.json";
    private final ObjectMapper objectMapper = new ObjectMapper();
    
    private List<ProductDto> products;
    
    public ProductRepository() {
		loadProducts();
	}
    
    private void loadProducts() {
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                products = objectMapper.readValue(file, new TypeReference<List<ProductDto>>() {});
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
	public void save(ProductDto product) {
		if(product != null) {
		    products.add(product);
		    saveProducts();
		}
	}

	@Override
	public List<ProductDto> getAll() {
		return products;
	}

	@Override
	public ProductDto getById(int id) {
		for (ProductDto productDto : products) {
			if(productDto.getId() == id) {
				return productDto;
			}
		}
		return null;
	}

	@Override
	public String deleteById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateById(int id, ProductDto updatedProduct) {
		// TODO Auto-generated method stub
		return null;
	}

}
