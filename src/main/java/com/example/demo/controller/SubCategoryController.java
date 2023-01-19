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

import com.example.demo.entity.SubCategory;
import com.example.demo.service.SubCategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/subcategory/")
@RequiredArgsConstructor
public class SubCategoryController {

	private SubCategoryService subCategoryService;

	@GetMapping
	public ResponseEntity<List<SubCategory>> findAll() {
		return new ResponseEntity<List<SubCategory>>(subCategoryService.findAll(), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<SubCategory> findById(@PathVariable Long id) {
		return new ResponseEntity<SubCategory>(subCategoryService.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<SubCategory> save(@RequestBody SubCategory subCategory) {
		return new ResponseEntity<SubCategory>(subCategoryService.save(subCategory), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<SubCategory> update(@RequestBody SubCategory subCategory) {
		return new ResponseEntity<SubCategory>(subCategoryService.update(subCategory), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Object> update(@PathVariable Long id) {
		subCategoryService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
