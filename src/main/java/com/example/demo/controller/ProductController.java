package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product/")
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		return new ResponseEntity<List<Product>>(productService.findAll(), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		return new ResponseEntity<Product>(productService.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Product> save(@RequestBody Product product) {
		return new ResponseEntity<Product>(productService.save(product), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Product> update(@RequestBody Product product) {
		return new ResponseEntity<Product>(productService.update(product), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Object> update(@PathVariable Long id) {
		productService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
