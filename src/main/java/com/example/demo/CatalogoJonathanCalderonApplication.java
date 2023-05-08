package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.transaction.Transactional;
 
@CrossOrigin(origins = "*")
@RestController
@SpringBootApplication
public class CatalogoJonathanCalderonApplication  implements CommandLineRunner{

	
	public static void main(String[] args) {
		SpringApplication.run(CatalogoJonathanCalderonApplication.class, args);
	}
	
	//VALIDADO FUNCIONA PERFECTAMENTE
	@GetMapping("/")
	public String index() {
		return "Hi Capgemini!,Greetings from Spring Boot";
	}
	
	@GetMapping("/vista")
	public ModelAndView vista() {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("index.html");
	    return modelAndView;
	}
	
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		System.out.println("Aplicacion iniciada");		
	}
	
}
