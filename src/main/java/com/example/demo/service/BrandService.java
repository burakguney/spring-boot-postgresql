package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Brand;
import com.example.demo.repository.BrandRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BrandService {

	private final BrandRepository brandRepository;

	public Brand save(Brand category) {
		return brandRepository.save(category);
	}

	public Brand findById(Long id) {
		return brandRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Brand not found with id: " + id));
	}

	public List<Brand> findAll() {
		return brandRepository.findAll();
	}

	public Brand update(Brand brand) {
		findById(brand.getId());
		return brandRepository.save(brand);
	}

	public void deleteById(Long id) {
		brandRepository.deleteById(id);
	}
}
