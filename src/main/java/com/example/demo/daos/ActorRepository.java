package com.example.demo.daos;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

//import com.example.domains.core.contracts.repositories.RepositoryWithProjections;
import com.example.demo.entities.Actor;
import com.example.demo.servicios.apoyos.RepositoryWithProjections;

/*
 * El funcionamiento como hemos comentado en clase
 * de un repositorio es tener toda la logica para la base de datos
 * insert,update,delete,etc
 * 
 * pero algo muy importante: "Solamente de una sola entidad"
 * */

public interface ActorRepository extends JpaRepository<Actor, Integer>, JpaSpecificationExecutor<Actor>,RepositoryWithProjections {
}
