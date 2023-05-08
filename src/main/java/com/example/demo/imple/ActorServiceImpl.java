package com.example.demo.imple;

import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.daos.ActorRepository;
import com.example.demo.dtos.ActorDTO;
import com.example.demo.entities.Actor;
import com.example.demo.excepciones.DuplicateKeyException;
import com.example.demo.excepciones.InvalidDataException;
import com.example.demo.excepciones.NotFoundException;
import com.example.demo.servicios.ActorService;

import jakarta.transaction.Transactional;

import org.modelmapper.ModelMapper;

import lombok.NonNull;

@Service
public class ActorServiceImpl implements ActorService {
	/*Para que usamos una inyeccion de dependencia aqui?
	 * para tener un solo sitio donde se cambien los datos
	 * y que no me usan la DAO en cualquier sitio sino especificamente en su servicios
	 * ademas aqui podremos agregar una nueva capa de validacion
	*/
	@Autowired
	ActorRepository daoActor;
	private final ModelMapper mapper = new ModelMapper();
	@Autowired
	JdbcTemplate template;
	
	
	//UTILIZADO EN EL METODO GET
	public List<ActorDTO> getAllDtosActor(){
		return daoActor.findAll().stream().map(this::maptoDTO).collect(Collectors.toList());
	}
	
	//UTILIZADO EN EL METODO GET CON ID
	public ActorDTO getActorById(Integer id){
		if(daoActor.existsById(id)) {
			return maptoDTO(daoActor.findById(id).get());
		}
		ActorDTO dto= new ActorDTO();
		dto.setFirstName("No existe este actor");
		dto.setLastName("No existe este actor");
		return dto;
	}
		
	//UTILIZADO EN EL METODO POST
	public ActorDTO createActor(ActorDTO actorDTO) {
		Actor actor = mapToEntity(actorDTO);
		return maptoDTO(daoActor.save(actor));
	}
	//UTILIZADO EN EL METODO UPDATE
	@Transactional
	public String updateActor(Integer id,String firstname,String lastname){
		Actor act=daoActor.getReferenceById(id);
		if(daoActor.existsById(id)) {
			act.setFirstName(firstname.toUpperCase());
			act.setLastName(lastname.toUpperCase());
			daoActor.save(act);
			return "Actualización éxitosa";
		}else {
			return "Actualizacion sin éxito";
		}
	}
	//VALIDADO AHORA SI ELIMINA EL ACTOR
	public String deleteActor(Integer id){
		Actor a=daoActor.getReferenceById(id);
		if(daoActor.existsById(id)) {
			template.execute(MessageFormat.format("delete from film_actor where actor_id={0}", id));
			daoActor.deleteById(a.getActorId());
			return "Actor borrado";
		}else {
			return "No existe este Actor";
		}
	}
	
	public Actor mapToEntity(ActorDTO actorDTO) {
		return mapper.map(actorDTO, Actor.class);
	}
	
	public ActorDTO maptoDTO(Actor a) {
		return mapper.map(a, ActorDTO.class);
	}
	
	
	/*
	 6 #####################################
	  ### MÉTODOS DE ABAJO NO LO USARÉ ####
	  #####################################
	*/
	@Override
	public <T> List<T> getAllInstances(Class<T> type) {
		// TODO Auto-generated method stub
		return daoActor.findAllBy(type);
	}
	@Override
	public Optional<Actor> getOne(Integer id) {
		return daoActor.findById(id);
	}
	@Override
	public Actor add(Actor item) throws DuplicateKeyException, InvalidDataException {
		return item;
	}
	@Override
	public Actor modify(Actor item) throws NotFoundException, InvalidDataException {
		return item;
	}
	@Override
	public void delete(Actor item) throws InvalidDataException {
	}
	@Override
	public void deleteById(Integer id) {
	}
	@Override
	public <T> Iterable<T> getByProjection(Sort sort, Class<T> type) {
		return null;
	}
	@Override
	public <T> Page<T> getByProjection(Pageable pageable, Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Iterable<Actor> getAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Page<Actor> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Actor> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
