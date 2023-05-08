package com.example.demo.daos;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entities.Actor;
import com.example.demo.entities.Category;
import com.example.demo.servicios.apoyos.RepositoryWithProjections;

public interface CategoryRepository extends JpaRepository<Category, Integer> ,JpaSpecificationExecutor<Category>,RepositoryWithProjections{
	
}
