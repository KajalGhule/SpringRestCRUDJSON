package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.ProductDto;
import com.example.services.ProductService;

@CrossOrigin
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
		
		@GetMapping("/getall")
		public ResponseEntity<List<ProductDto>> getAllProducts() {
			List<ProductDto> products = productService.getAll();
			return ResponseEntity.ok(products);
		}
		@GetMapping("/{id}")
		public ResponseEntity<ProductDto> getProductById(@PathVariable int id) {
			ProductDto product = productService.getById(id);
			if(product != null) {
				return ResponseEntity.ok(product);
			}
			return ResponseEntity.notFound().build();
		}

		@PutMapping("/{id}")
		public ResponseEntity<String> updatebyId(@PathVariable int id, @RequestBody ProductDto product) {
			boolean isUpadeted = productService.updateById(id, product);
			if(isUpadeted) {
				return ResponseEntity.ok("Product with Id "+ id +" update successfully");
			}
			return ResponseEntity.ok("Product with Id "+ id +" not found");
		}
		
		@DeleteMapping
		public ResponseEntity<?> deletedById(@RequestParam int id) {
			boolean isDeleted = productService.deleteById(id);
			if(isDeleted) {
				return ResponseEntity.ok("Product with Id "+ id +" delete successfully");
			}
			return ResponseEntity.ok("Product with Id "+ id +" not found");
		}
		
}
