package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Brand {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String brandName;
	@ManyToOne
	@JsonBackReference
	private SubCategory subCategory;
}
