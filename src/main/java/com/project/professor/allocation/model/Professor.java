package com.project.professor.allocation.model;

public class Professor {
	private Long id;
	private String cpf;
	private String name;

	public Professor() {
		super();
	}

	public Professor(Long id, String cpf, String name) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
