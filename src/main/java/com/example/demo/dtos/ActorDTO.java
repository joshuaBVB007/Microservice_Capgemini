package com.example.demo.dtos;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Actor;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Value;

@Service
@Data
public class ActorDTO {
	@JsonProperty("id")
	private int actorId;
	@JsonProperty("nombre")
	private String firstName;
	@JsonProperty("apellidos")
	private String lastName;
	
	public ActorDTO(){
	}
}
