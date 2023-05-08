package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.FilmDTO;
import com.example.demo.entities.Film;
import com.example.demo.entities.Language;
import com.example.demo.imple.FilmServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;

@CrossOrigin(origins = "*")
@RestController
public class FilmController {
	
		@Autowired
		FilmServiceImpl impleFilm;

		//ENDPOINTS FILM
		@GetMapping(path="/film")      //VALIDADO
		public @ResponseBody List<FilmDTO> getAllFilmsInBBDD() throws JsonProcessingException {
			return impleFilm.getAllDtosFilms();
		}
		@GetMapping(path="/film/{id}") //VALIDADO
		public @ResponseBody FilmDTO getFilmById(@PathVariable Integer id) {
			return impleFilm.getFilmById(id);
		}
		@PostMapping(path="/film") //VALIDADO
		public @ResponseBody FilmDTO addNewFilm(@RequestParam String title,@RequestParam String desc) {
			
			var v=new Film();
			v.setTitle(title);
			v.setDescription(desc);
			v.setLength(20);
			v.setRating("G");
			Language lang=new Language();
			lang.setLanguageId(1);
			v.setLanguage1(lang);
			v.setLanguage2(lang);
			
			return impleFilm.createFilm(v);
		}
		@PutMapping(path = "/film/{id}")//VALIDADO
		public @ResponseBody String putFilm(@PathVariable Integer id,@RequestParam String title,@RequestParam String desc){
			return impleFilm.updateFilm(id,title,desc);
		}
		
		/* ESTE METODO DE REMOVER PELICULAS NO SE HIZO PORQUE MOVER UNA PELICULA ES MOVER MEDIA BBDD
		@DeleteMapping(path = "/film/{id}")
		public @ResponseBody String deleteFilm(@PathVariable Integer id){
			return impleFilm.deleteFilm(id);	
		}
		*/	
	
}
