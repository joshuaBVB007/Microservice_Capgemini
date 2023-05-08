package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.CategoryDTO;
import com.example.demo.imple.CategoryServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;

@CrossOrigin(origins = "*")
@RestController
public class CategoryController {
		@Autowired
		CategoryServiceImpl impleCategory;

		//ENDPOINTS CATEGORY
		@GetMapping(path="/category") //VALIDADO
		public @ResponseBody List<CategoryDTO> getAllCategoriesInBBDD() throws JsonProcessingException {
			return impleCategory.getAllDtosCategories();
		}
		@GetMapping(path="/category/{id}")//VALIDADO
		public @ResponseBody CategoryDTO getCategoryById(@PathVariable Integer id) {
			return impleCategory.getCategoryById(id);
		}
		@PostMapping(path="/category")//VALIDADO
		public @ResponseBody CategoryDTO addNewCategory(@RequestParam String nameCategory) {
			var a=new CategoryDTO();
			a.setCategoryId(0);
			a.setCategoryName(nameCategory.toUpperCase());
			return impleCategory.createCategory(a);
		}
		@PutMapping(path = "/category/{id}") //VALIDADO
		public @ResponseBody String putCategory(@PathVariable Integer id,@RequestParam String name){
			return impleCategory.updateCategory(id,name);
		}
		@DeleteMapping(path = "/category/{id}") //VALIDADO
		public @ResponseBody String deleteCategory(@PathVariable Integer id){
				return impleCategory.deleteCategory(id);
		}
	
}
