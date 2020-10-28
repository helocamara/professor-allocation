package com.project.professor.allocation.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	/*
	 * Um departamento para varios professores, se são vários professores, eu
	 * preciso de uma LISTA de professores.
	 * LAZY significa que ele nao vai carregar toda a lista de professores quando chamar um departamento
	 * MappedBy só precisa especificar quando é OneToMany
	 */
	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Professor> professors;

	public Department() {
		super();
	}

	public Department(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public List<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
