package com.example.demo.imple;

import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.daos.ActorRepository;
import com.example.demo.daos.CategoryRepository;
import com.example.demo.dtos.ActorDTO;
import com.example.demo.dtos.CategoryDTO;
import com.example.demo.entities.Actor;
import com.example.demo.entities.Category;
import com.example.demo.excepciones.DuplicateKeyException;
import com.example.demo.excepciones.InvalidDataException;
import com.example.demo.excepciones.NotFoundException;
import com.example.demo.servicios.CategoryService;

import jakarta.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;



@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryRepository daoCategory;
	private final ModelMapper mapper = new ModelMapper();
	@Autowired
	JdbcTemplate template;
	
	

	//UTILIZADO EN EL METODO GET
	public List<CategoryDTO> getAllDtosCategories(){
		return daoCategory.findAll().stream().map(this::maptoDTO).collect(Collectors.toList());
	}
	
	//UTILIZADO EN EL METODO GET CON ID
	public CategoryDTO getCategoryById(Integer id){
		if(daoCategory.existsById(id)) {
			return maptoDTO(daoCategory.findById(id).get());
		}
		CategoryDTO dto= new CategoryDTO();
		dto.setCategoryName("No existe esta Categoria");
		return dto;
	}
	
		
	//UTILIZADO EN EL METODO POST
	public CategoryDTO createCategory(CategoryDTO catDTO) {
		Category actor = mapToEntity(catDTO);
		return maptoDTO(daoCategory.save(actor));
	}
	//UTILIZADO EN EL METODO UPDATE
	@Transactional
	public String updateCategory(Integer id,String name){
		Category act=daoCategory.getReferenceById(id);
		if(daoCategory.existsById(id)) {
			act.setName(name.toUpperCase());
			daoCategory.save(act);
			return "Actualización éxitosa";
		}else {
			return "Actualizacion sin éxito";
		}
	}

	public String deleteCategory(Integer id){
		Category a=daoCategory.getReferenceById(id);
		if(daoCategory.existsById(id)) {
			template.execute(MessageFormat.format("delete from film_category where category_id={0}", id));
			//el profesor lo hizo de tipo integer
			daoCategory.deleteById(a.getCategoryId());
			return "Categoria borrada";
		}else {
			return "No existe esta Categoria";
		}
	}
	
	public Category mapToEntity(CategoryDTO catDTO) {
		return mapper.map(catDTO, Category.class);
	}
	
	public CategoryDTO maptoDTO(Category a) {
		return mapper.map(a, CategoryDTO.class);
	}
	
	/*
	  #####################################
	  ### MÉTODOS DE ABAJO NO LO USARÉ ####
	  #####################################
	*/
	
	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Optional<Category> getOne(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
	@Override
	public Category add(Category item) throws DuplicateKeyException, InvalidDataException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Category modify(Category item) throws NotFoundException, InvalidDataException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete(Category item) throws InvalidDataException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}
	

	
}
