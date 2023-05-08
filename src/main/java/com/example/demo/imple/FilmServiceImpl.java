package com.example.demo.imple;

import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.daos.ActorRepository;
import com.example.demo.daos.FilmRepository;
import com.example.demo.dtos.ActorDTO;
import com.example.demo.dtos.FilmDTO;
import com.example.demo.entities.Actor;
import com.example.demo.entities.Film;
import com.example.demo.excepciones.DuplicateKeyException;
import com.example.demo.excepciones.InvalidDataException;
import com.example.demo.excepciones.NotFoundException;
import com.example.demo.servicios.FilmService;

import jakarta.transaction.Transactional;
import lombok.NonNull;

@Service
public class FilmServiceImpl implements FilmService {
	@Autowired
	FilmRepository daoFilm;

	private final ModelMapper mapper = new ModelMapper();
	@Autowired
	JdbcTemplate template;
	
	
	//UTILIZADO EN EL METODO GET
	public List<FilmDTO> getAllDtosFilms(){
		return daoFilm.findAll().stream().map(this::maptoDTO).collect(Collectors.toList());
	}
	
	//UTILIZADO EN EL METODO GET CON ID
	public FilmDTO getFilmById(Integer id){
		if(daoFilm.existsById(id)) {
			return maptoDTO(daoFilm.findById(id).get());
		}
		FilmDTO dto= new FilmDTO();
		dto.setTitleFilm("No existe este film");
		dto.setDescriptionFilm("No existe este film");
		dto.setRatingFilm("PG");
		return dto;
	}
		
	//UTILIZADO EN EL METODO POST
	public FilmDTO createFilm(Film film) {
		return maptoDTO(daoFilm.save(film));
	}
	
	//UTILIZADO EN EL METODO UPDATE
	@Transactional
	public String updateFilm(Integer id,String firstname,String lastname){
		Film act=daoFilm.getReferenceById(id);
		if(daoFilm.existsById(id)) {
			act.setTitle(firstname.toUpperCase());
			act.setDescription(lastname.toUpperCase());
			daoFilm.save(act);
			return "Actualización éxitosa";
		}else {
			return "Actualizacion sin éxito";
		}
	}
	//Este metodo no lo hago porque pelicula esta vinculada con media base de datos
//	@Transactional
//	public String deleteFilm(Integer id){
//		Film a=daoFilm.getReferenceById(id);
//		if(daoFilm.existsById(id)) {
//			template.execute(MessageFormat.format("delete from film_category where film_id={0}", id));
//			template.execute(MessageFormat.format("delete from film_actor where film_id={0}", id));
//			template.execute(MessageFormat.format("delete from inventory where film_id={0}", id));
//			daoFilm.deleteById(a.getFilmId());
//			return "Pelicula borrada";
//		}else {
//			return "No existe esta Pelicula";
//		}
//	}
	
	public Film mapToEntity(FilmDTO filmDTO) {
		return mapper.map(filmDTO, Film.class);
	}
	
	public FilmDTO maptoDTO(Film a) {
		return mapper.map(a, FilmDTO.class);
	}
	
	
	/*
	  #####################################
	  ### MÉTODOS DE ABAJO NO LO USARÉ ####
	  #####################################
	*/
	
	
	

	@Override
	public <T> List<T> getAllInstances(Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Iterable<T> getByProjection(Sort sort, Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Page<T> getByProjection(Pageable pageable, Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Film> getAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Film> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Film> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Film> getOne(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Film add(Film item) throws DuplicateKeyException, InvalidDataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Film modify(Film item) throws NotFoundException, InvalidDataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Film item) throws InvalidDataException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}


	
}
