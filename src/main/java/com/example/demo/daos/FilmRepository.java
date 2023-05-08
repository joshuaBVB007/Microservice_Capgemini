package com.example.demo.daos;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entities.*;
import com.example.demo.servicios.apoyos.RepositoryWithProjections;

public interface FilmRepository extends JpaRepository<Film, Integer>,JpaSpecificationExecutor<Film>,RepositoryWithProjections {
	
}
