package com.example.demo.servicios.apoyos;

import java.util.List;
import java.util.Optional;

import com.example.demo.excepciones.*;

public interface DomainService<E, K> {
	List<E> getAll();
	
	Optional<E> getOne(K id);
	
	E add(E item) throws DuplicateKeyException, InvalidDataException;
	
	E modify(E item) throws NotFoundException, InvalidDataException;
	
	void delete(E item) throws InvalidDataException;
	void deleteById(K id);
}
