package com.example.demo.dtos;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Service
@Data
public class CategoryDTO {
	@JsonProperty("id")
	private int categoryId;
	@JsonProperty("nombre")
	private String categoryName;
	
	public CategoryDTO(){
	}
}
