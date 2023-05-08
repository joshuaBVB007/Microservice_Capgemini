package com.example.demo.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * The persistent class for the film database table.
 * 
 */
@Entity
@NamedQuery(name="Film.findAll", query="SELECT f FROM Film f")
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="film_id",unique=true, nullable=false)
	private int filmId;
	
	@NotBlank
	@Size(max=100, min=2)
	@Column(name="title",nullable = false)
	private String title;

	@NotBlank
	@Size(max=100, min=2)
	@Column(name="description")
	private String description;
	
	@Column(name="last_update",insertable=false, updatable=false, nullable=false)
	private Timestamp lastUpdate;

	@Column(name="length",nullable=false)
	private Integer length;

	@Column(name="rating",insertable=false, updatable=false, nullable=false)
	private String rating;
	
	@Temporal(TemporalType.DATE)
	@Column(name="release_year",insertable=false, updatable=false, nullable=false)
	private Date releaseYear;

	@Column(name="rental_duration",insertable=false, updatable=false, nullable=false)
	private int rentalDuration;

	@Column(name="rental_rate",insertable=false, updatable=false, nullable=false)
	private BigDecimal rentalRate;

	@Column(name="replacement_cost",insertable=false, updatable=false, nullable=false)
	private BigDecimal replacementCost;

	@Column(name="special_features", nullable = false)
	private Object specialFeatures;

	public Film(){
		
	}
	
	public Film(int filmId,String title,String description,int length,String rating,Date date) {
	}
	

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="language_id",unique=true, nullable=false)
	private Language language1;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="original_language_id")
	private Language language2;

	public int getFilmId() {
		return this.filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public int getLength() {
		return this.length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Date getReleaseYear() {
		return this.releaseYear;
	}

	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getRentalDuration() {
		return this.rentalDuration;
	}

	public void setRentalDuration(byte rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public BigDecimal getRentalRate() {
		return this.rentalRate;
	}

	public void setRentalRate(BigDecimal rentalRate) {
		this.rentalRate = rentalRate;
	}

	public BigDecimal getReplacementCost() {
		return this.replacementCost;
	}

	public void setReplacementCost(BigDecimal replacementCost) {
		this.replacementCost = replacementCost;
	}

	public Object getSpecialFeatures() {
		return this.specialFeatures;
	}

	public void setSpecialFeatures(Object specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Language getLanguage1() {
		return this.language1;
	}

	public void setLanguage1(Language language1) {
		this.language1 = language1;
	}

	public Language getLanguage2() {
		return this.language2;
	}

	public void setLanguage2(Language language2) {
		this.language2 = language2;
	}

}