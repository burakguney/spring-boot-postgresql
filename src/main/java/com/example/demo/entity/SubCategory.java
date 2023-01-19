package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class SubCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String subCategoryName;
	@ManyToOne
	@JsonBackReference
	private Category category;
	@OneToMany(mappedBy = "subCategory")
	private List<Brand> brands;
}
