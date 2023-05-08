package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="category_id")
	private Integer categoryId;

	@Column(name="last_update",insertable=false, updatable=false, nullable=false)
	private Timestamp lastUpdate;

	@Column(name="name")
	@NotBlank
	@Size(max=45, min=2)
	private String name;

	public Category() {
	}

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}