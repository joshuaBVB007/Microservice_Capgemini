package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dtos.LanguageDTO;
import com.example.demo.imple.LanguageServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;

import jakarta.transaction.Transactional;

@CrossOrigin(origins = "*")
@RestController
public class LanguageController {
	
	@Autowired
	LanguageServiceImpl impleLanguage;

	//ENDPOINTS LANGUAGES VALIDADOS TODOS
	@GetMapping(path="/language")
	public @ResponseBody List<LanguageDTO> getLanguagesInBBDD() throws JsonProcessingException {
		return impleLanguage.getAllDtosLanguages();
	}
	
	@GetMapping(path="/language/{id}")
	public @ResponseBody LanguageDTO getLanguageById(@PathVariable Integer id) {
		return impleLanguage.getLanguageById(id);
	}
	
	@PostMapping(path="/language")
	public @ResponseBody LanguageDTO postLanguage(@RequestParam String name) {
		var a=new LanguageDTO();
		a.setLanguageId(0);
		a.setName(name);
		return impleLanguage.createLanguage(a);
	}
	
	@PutMapping(path = "/language/{id}")
	public @ResponseBody String putLanguage(@PathVariable Integer id,@RequestParam String name){
		return impleLanguage.updateLanguage(id,name);
	}
	
	@Transactional
	@DeleteMapping(path = "/language/{id}")
	public @ResponseBody String deleteLanguage(@PathVariable Integer id){
			return impleLanguage.deleteLanguage(id);
	}
}
