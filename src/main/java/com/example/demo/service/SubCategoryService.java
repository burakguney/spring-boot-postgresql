package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.SubCategory;
import com.example.demo.repository.SubCategoryRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubCategoryService {

	private final SubCategoryRepository subCategoryRepository;

	public SubCategory save(SubCategory subCategory) {
		return subCategoryRepository.save(subCategory);
	}

	public SubCategory findById(Long id) {
		return subCategoryRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("SubCategory not found with id: " + id));
	}

	public List<SubCategory> findAll() {
		return subCategoryRepository.findAll();
	}

	public SubCategory update(SubCategory subCategory) {
		findById(subCategory.getId());
		return subCategoryRepository.save(subCategory);
	}

	public void deleteById(Long id) {
		subCategoryRepository.deleteById(id);
	}
}
