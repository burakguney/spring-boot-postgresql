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

import com.example.demo.entity.Brand;
import com.example.demo.service.BrandService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/brand/")
@RequiredArgsConstructor
public class BrandController {

	private final BrandService brandService;

	@GetMapping
	public ResponseEntity<List<Brand>> findAll() {
		return new ResponseEntity<List<Brand>>(brandService.findAll(), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Brand> findById(@PathVariable Long id) {
		return new ResponseEntity<Brand>(brandService.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Brand> save(@RequestBody Brand brand) {
		return new ResponseEntity<Brand>(brandService.save(brand), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Brand> update(@RequestBody Brand brand) {
		return new ResponseEntity<Brand>(brandService.update(brand), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Object> update(@PathVariable Long id) {
		brandService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
