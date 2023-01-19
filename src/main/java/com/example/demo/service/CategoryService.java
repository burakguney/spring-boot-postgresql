package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {

	private final CategoryRepository categoryRepository;

	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	public Category findById(Long id) {
		return categoryRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + id));
	}

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public Category update(Category category) {
		findById(category.getId());
		return categoryRepository.save(category);
	}

	public void deleteById(Long id) {
		categoryRepository.deleteById(id);
	}

}
