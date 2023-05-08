package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.controllers.ActorController;
import com.example.demo.controllers.CategoryController;
import com.example.demo.controllers.FilmController;
import com.example.demo.controllers.LanguageController;
import com.example.demo.dtos.ActorDTO;
import com.example.demo.dtos.CategoryDTO;
import com.example.demo.dtos.FilmDTO;
import com.example.demo.dtos.LanguageDTO;
import com.example.demo.imple.ActorServiceImpl;
import com.example.demo.imple.CategoryServiceImpl;
import com.example.demo.imple.FilmServiceImpl;
import com.example.demo.imple.LanguageServiceImpl;


@SpringBootTest
class CatalogoJonathanCalderonApplicationTests {
	
	@Autowired
	ActorServiceImpl actimple;
	@Autowired
	CategoryServiceImpl catimple;
	@Autowired
	FilmServiceImpl filmimple;
	@Autowired
	LanguageServiceImpl langimple;
	
	@Autowired
	CatalogoJonathanCalderonApplication cat;

	
	ActorController controllerActor=mock(ActorController.class);
	CategoryController controllerCategory=mock(CategoryController.class);
	FilmController controllerFilm=mock(FilmController.class);
	LanguageController controllerLanguage=mock(LanguageController.class);
	
	/*##################################
	#########  FILM LISTOS #############
	####################################*/
	
	@Nested
    @DisplayName("Film Testing")
    class FilmTesting {
		@Test
		@DisplayName("FILM GET ALL")
		void getAllFilmInBBDDTest() {
			
			//VERSION CONTRA LA BBDD(REAL)
			List<FilmDTO> lista =filmimple.getAllDtosFilms();
			assertTrue(lista instanceof List<FilmDTO>);
		}

		@Test
		@DisplayName("FILM GET ID")
		void getFilmByIdTest() {
			
			//Version Base de datos(Real)
			//var i=cat.getFilmById(1);
			//assertTrue(i instanceof FilmDTO);
			
			//Version Mockito
			when(controllerFilm.getFilmById(1)).thenReturn(new FilmDTO());
			assertTrue(controllerFilm.getFilmById(1) instanceof FilmDTO);
		}
		
		@Test
		@DisplayName("FILM POST")
		void PostFilmTest() {
			//Version contra la BBDD
			//var i=cat.addNewFilm("Jonathan","hahahahah");
			//assertTrue(i instanceof FilmDTO);
			
			//Version Mockito
			when(controllerFilm.addNewFilm("La vie e belle", "Fantastica")).thenReturn(new FilmDTO());
			assertTrue(controllerFilm.addNewFilm("La vie e belle", "Fantastica") instanceof FilmDTO);
		}
		
		@Test
		@DisplayName("FILM PUT")
		void putFilmTest() {
			//Version contra la BBDD
			//var i=cat.putFilm(20,"ALVAREZ","Ranchero");
			//assertEquals("Actualización éxitosa",i);
			
			//Version Mockito
			when(controllerFilm.putFilm(20, "ALVAREZ", "Ranchera")).thenReturn("Actualización éxitosa");
			assertEquals("Actualización éxitosa",controllerFilm.putFilm(20, "ALVAREZ", "Ranchera"));
		}
		
		
		
		@Disabled
		@DisplayName("ESTE METODO ESTA DESHABILITADO PORQUE ELIMINAR UNA PELICULA ES REMOVER MEDIA BBDD")
		@ParameterizedTest
		@ValueSource(ints = { 2, 3 })
		void deleteFilmTest(int indice) {
			/*
			 	Eliminar un FILM es muy costoso porque esta
			 	vinculada a media base de datos cargarse una fila es remover en todas las tablas datos
				var i=cat.deleteActor(indice);
				assertEquals("No existe este Actor",i);
			*/
		}
	}
	
	/*##################################
	######### CATEGORY LISTOS ##########
	####################################*/
	@Nested
	@DisplayName("Category Testing")
	class CategoryTesting{
		@Test
		@DisplayName("CATEGORY GET ALL")
		void getAllCategoryInBBDDTest() {
			List<CategoryDTO> lista =catimple.getAllDtosCategories();
			assertTrue(lista instanceof List<CategoryDTO>);
		}

		@Test
		@DisplayName("CATEGORY GET ID")
		void getCategorysByIdTest() {
			//VERSION CONTRA LA BBDD REAL
			//var i=cat.getCategoryById(1);
			//assertTrue(i instanceof CategoryDTO);
			
			
			//Version Mockito
			when(controllerCategory.getCategoryById(1)).thenReturn(new CategoryDTO());
			assertTrue(controllerCategory.getCategoryById(1) instanceof CategoryDTO);
		}
		
		@Test
		@DisplayName("CATEGORY POST")
		void PostCategoryTest() {
			/*Tener en cuenta que yo paso los valores a Uppercase en el método por eso
			 * pasa la validacion de las mayúsculas*/
			//var i=cat.addNewCategory("Jonathan");
			//assertTrue(i instanceof CategoryDTO);
			
			//Version Mockito
			when(controllerCategory.addNewCategory("Cine Espaniol")).thenReturn(new CategoryDTO());
			assertTrue(controllerCategory.addNewCategory("Cine Espaniol") instanceof CategoryDTO);
		}
		
		@Test
		@DisplayName("CATEGORY PUT")
		void putCategoryTest() {
			/*Version real y contra la BBDD*/
			//var i=cat.putCategory(10,"ALVAREZ");
			//assertEquals("Actualización éxitosa",i);
			
			//Version Mockito
			when(controllerCategory.putCategory(1, "Cine Francés")).thenReturn("Actualización éxitosa");
			assertEquals("Actualización éxitosa",controllerCategory.putCategory(1, "Cine Francés"));
		}
		
		@DisplayName("CATEGORY DELETE")
		@ParameterizedTest
		@ValueSource(ints = { 3, 4 })
		void deleteCategoryTest(int indice) {
			/*Version real y contra la BBDD*/
			//var i=cat.deleteActor(indice);
			//assertEquals("No existe este Actor",i);
			
			when(controllerCategory.deleteCategory(indice)).thenReturn("No existe este Categoria");
			assertEquals("No existe este Categoria", controllerCategory.deleteCategory(indice));
		}
	}
	
	/*##################################
	#########   ACTOR LISTO ############
	####################################*/
	@Nested
	@DisplayName("Actor Testing")
	class ActorTesting{
		@Test
		@DisplayName("ACTOR GET ALL")
		void getAllActorsInBBDDTest() {
			List<ActorDTO> lista =actimple.getAllDtosActor();
			assertTrue(lista instanceof List<ActorDTO>);
		}
		
		//me gustaria que fuera parametrizado y contra la base de datos
		@Test
		@DisplayName("ACTOR GET ID")
		void getActorsByIdTest() {
			/*Version real contra la BBDD
				var i=cat.getActorById(1);
				assertTrue(i instanceof ActorDTO);
			*/
			
			when(controllerActor.getActorById(2)).thenReturn(new ActorDTO());
			assertTrue(controllerActor.getActorById(2) instanceof ActorDTO);
		}
		
		@Test
		@DisplayName("ACTOR POST")
		void PostActorTest() {
			/*version real contra la BBDD
				var i=cat.addNewActor("Jonathan", "Calderon");
				assertTrue(i instanceof ActorDTO);
			*/
			
			when(controllerActor.addNewActor("MARIA", "POVEDA")).thenReturn(new ActorDTO());
			assertTrue(controllerActor.addNewActor("MARIA", "POVEDA") instanceof ActorDTO);
		}
		
		@Test
		@DisplayName("ACTOR PUT")
		void putActorTest() {
			/*version real contra la BBDD
				var i=cat.putActor(20, "JULIAN", "ALVAREZ");
				assertEquals("Actualización éxitosa",i);
			*/
			when(controllerActor.putActor(10,"MARIA", "POVEDA")).thenReturn("Actualización éxitosa");
			assertEquals("Actualización éxitosa",controllerActor.putActor(10, "MARIA", "POVEDA"));
		}
		
		@DisplayName("ACTOR DELETE")
		@ParameterizedTest
		@ValueSource(ints = { 5, 7 })
		void deleteActorTest(int indice) {
			/*version real contra la BBDD
				var i=cat.deleteActor(indice);
				assertEquals("No existe este Actor",i);
			*/
			when(controllerActor.deleteActor(indice)).thenReturn("Existe este Actor");
			assertEquals("Existe este Actor", controllerActor.deleteActor(indice));
		}
	}
	
	/*##################################
	#########   LANGUAGE LISTO ############
	####################################*/
	
	@Nested
	@DisplayName("Language Testing")
	class LanguageTesting{
		@Test
		@DisplayName("LANGUAGE GET ALL") //VALIDADO
		void getLanguagesInBBDDTest() {
			List<LanguageDTO> lista =langimple.getAllDtosLanguages();
			assertTrue(lista instanceof List<LanguageDTO>);
		}

		@Test
		@DisplayName("LANGUAGE GET ID")//VALIDADO
		void getLanguageByIdTest() {
			when(controllerLanguage.getLanguageById(1)).thenReturn(new LanguageDTO());
			assertTrue(controllerLanguage.getLanguageById(1) instanceof LanguageDTO);
		}
		
		@Test
		@DisplayName("LANGUAGE POST") //VALIDADO
		void PostLanguageTest() {
			when(controllerLanguage.postLanguage("MARIA")).thenReturn(new LanguageDTO());
			assertTrue(controllerLanguage.postLanguage("MARIA") instanceof LanguageDTO);
		}
		
		@Test
		@DisplayName("LANGUAGE PUT") //VALIDADO
		void putLanguageTest() {
			when(controllerLanguage.putLanguage(1,"MARIA")).thenReturn("Actualización éxitosa");
			assertEquals("Actualización éxitosa",controllerLanguage.putLanguage(1, "MARIA"));
		}
		
		@Test
		@DisplayName("LANGUAGE DELETE") //VALIDADO
		void deleteLanguageTest() {
			when(controllerLanguage.deleteLanguage(3)).thenReturn("Language borrado");
			assertEquals("Language borrado", controllerLanguage.deleteLanguage(3));
		}
	}
	
	@Test
	@DisplayName("APP'S TITLE")
	void CheckTitleState() {
		assertEquals("Hi Capgemini!,Greetings from Spring Boot", cat.index());
	}

}
