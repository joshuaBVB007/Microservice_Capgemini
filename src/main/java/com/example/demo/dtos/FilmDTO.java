package com.example.demo.dtos;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Service
@Data
public class FilmDTO {
	@JsonProperty("id")
	private int filmId;
	@JsonProperty("title")
	private String titleFilm;
	@JsonProperty("description")
	private String descriptionFilm;
	@JsonProperty("rating")
	private String ratingFilm;
	
	public FilmDTO(){
	}
}
