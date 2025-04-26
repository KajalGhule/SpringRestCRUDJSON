package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dto.ProductDto;
import com.example.services.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
		@Autowired
		private ProductService productService;
		
		@PostMapping
		public ResponseEntity<String> createProduct(@RequestBody ProductDto product) {
			productService.save(product);
			return ResponseEntity.ok("Product created successfully");
		}
}
