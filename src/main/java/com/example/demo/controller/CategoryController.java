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

import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/category/")
@RequiredArgsConstructor
public class CategoryController {

	private CategoryService categoryService;

	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		return new ResponseEntity<List<Category>>(categoryService.findAll(), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		return new ResponseEntity<Category>(categoryService.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Category> save(@RequestBody Category category) {
		return new ResponseEntity<Category>(categoryService.save(category), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Category> update(@RequestBody Category category) {
		return new ResponseEntity<Category>(categoryService.update(category), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Object> update(@PathVariable Long id) {
		categoryService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
