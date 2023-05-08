package com.example.demo.dtos;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Service
@Data
public class LanguageDTO {
	@JsonProperty("id")
	private int languageId;
	@JsonProperty("name")
	private String Name;
	@JsonProperty("lastUpdate")
	private String lastupdate;
	
	public LanguageDTO(){
	}
}
