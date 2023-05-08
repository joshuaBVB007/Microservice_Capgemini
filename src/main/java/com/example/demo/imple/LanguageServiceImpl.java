package com.example.demo.imple;

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

import com.example.demo.daos.LanguageRepository;
import com.example.demo.dtos.LanguageDTO;
import com.example.demo.entities.Language;
import com.example.demo.excepciones.DuplicateKeyException;
import com.example.demo.excepciones.InvalidDataException;
import com.example.demo.excepciones.NotFoundException;
import com.example.demo.servicios.LanguageService;

import jakarta.transaction.Transactional;

@Service
public class LanguageServiceImpl implements LanguageService{
	
	@Autowired
	LanguageRepository daoLanguage;
	private final ModelMapper mapper = new ModelMapper();
	@Autowired
	JdbcTemplate template;
	
	
	//UTILIZADO EN EL METODO GET
	public List<LanguageDTO> getAllDtosLanguages(){
		return daoLanguage.findAll().stream().map(this::maptoDTO).collect(Collectors.toList());
	}
	
	//UTILIZADO EN EL METODO GET CON ID
	public LanguageDTO getLanguageById(Integer id){
		if(daoLanguage.existsById(id)) {
			return maptoDTO(daoLanguage.findById(id).get());
		}
		LanguageDTO dto= new LanguageDTO();
		dto.setName("No existe este actor");
		return dto;
	}
		
	//UTILIZADO EN EL METODO POST
	public LanguageDTO createLanguage(LanguageDTO languageDTO) {
		Language language = mapToEntity(languageDTO);
		return maptoDTO(daoLanguage.save(language));
	}
	//UTILIZADO EN EL METODO UPDATE
	@Transactional
	public String updateLanguage(Integer id,String name){
		Language act=daoLanguage.getReferenceById(id);
		if(daoLanguage.existsById(id)) {
			act.setName(name);
			daoLanguage.save(act);
			return "Actualización éxitosa";
		}else {
			return "Actualizacion sin éxito";
		}
	}
	//VALIDADO AHORA SI ELIMINA EL ACTOR
	@Transactional
	public String deleteLanguage(Integer id){
		Language a=daoLanguage.getReferenceById(id);
		if(daoLanguage.existsById(id)) {
			daoLanguage.deleteById(a.getLanguageId());
			return "Language borrado";
		}else {
			return "No existe este Language";
		}
	}
	
	public Language mapToEntity(LanguageDTO languageDTO) {
		return mapper.map(languageDTO, Language.class);
	}
	
	public LanguageDTO maptoDTO(Language language) {
		return mapper.map(language, LanguageDTO.class);
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
	public Iterable<Language> getAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Language> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Language> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Optional<Language> getOne(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
	
	//LANGUAGE CRUD
	
	
	@Override
	public <T> List<T> getAllInstances(Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Language add(Language item) throws DuplicateKeyException, InvalidDataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Language modify(Language item) throws NotFoundException, InvalidDataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Language item) throws InvalidDataException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}


}
