package com.example.demo.servicios;

import java.sql.Timestamp;
import java.util.List;

import com.example.demo.entities.*;
import com.example.demo.servicios.apoyos.ProjectionDomainService;


/*
 * El actor service esta heredando de 3 interfaces que le aportan
 * funcionalidad las interfaces heredadas estan en el paquete de com.example.demo.servicios.apoyos
 * */
public interface ActorService extends ProjectionDomainService<Actor, Integer> {
	
}
