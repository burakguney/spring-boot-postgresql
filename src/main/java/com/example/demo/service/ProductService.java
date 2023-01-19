package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private ProductRepository productRepository;

	public Product save(Product product) {
		return productRepository.save(product);
	}

	public Product findById(Long id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product update(Product product) {
		findById(product.getId());
		return productRepository.save(product);
	}

	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}
}
