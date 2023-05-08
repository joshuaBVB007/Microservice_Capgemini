package com.example.demo.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entities.Actor;
import com.example.demo.entities.Language;
import com.example.demo.servicios.apoyos.RepositoryWithProjections;

public interface LanguageRepository extends JpaRepository<Language, Integer>, JpaSpecificationExecutor<Language>,RepositoryWithProjections {

}
