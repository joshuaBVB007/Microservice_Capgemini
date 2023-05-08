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

import com.example.demo.dtos.ActorDTO;
import com.example.demo.imple.ActorServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;

@CrossOrigin(origins = "*")
@Controller
public class ActorController {
	
		@Autowired
		ActorServiceImpl impleActor;
	
		//ENDPOINTS ACTOR VALIDADOS TODOS
		@GetMapping(path="/actor")
		public @ResponseBody List<ActorDTO> getAllActorsInBBDD() throws JsonProcessingException {
			return impleActor.getAllDtosActor();
		}
		
		@GetMapping(path="/actor/{id}")
		public @ResponseBody ActorDTO getActorById(@PathVariable Integer id) {
			return impleActor.getActorById(id);
		}
		
		@PostMapping(path="/actor")
		public @ResponseBody ActorDTO addNewActor(@RequestParam String firstname, @RequestParam String lastname) {
			var a=new ActorDTO();
			a.setActorId(0);
			a.setFirstName(firstname.toUpperCase());
			a.setLastName(lastname.toUpperCase());
			return impleActor.createActor(a);
		}
		
		@PutMapping(path = "/actor/{id}")
		public @ResponseBody String putActor(@PathVariable Integer id,@RequestParam String firstname,@RequestParam String lastname){
			return impleActor.updateActor(id,firstname,lastname);
		}
		
		@DeleteMapping(path = "/actor/{id}")
		public @ResponseBody String deleteActor(@PathVariable Integer id){
				return impleActor.deleteActor(id);
		}

}
