package com.project.professor.allocation.model;

import java.sql.Time;
import java.time.DayOfWeek;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * Entity sáo classes que mapeiam as tabelas no seu código. 
 * Essa classe é uma entidade, ela representa uma tabela
 * */
@Entity

/*
 * Identifica a tabela que ta sendo mapeada. O nome da tabela é allocation no db
 */
@Table(name = "allocation")
public class Allocation {

	// Representa a coluna de Id da sua tabela
	@Id

	// Vai ser uma ID de autoincremento
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/*
	 * Essa anotação informa o formato que você quer que seja armazenado na coluna.
	 * Nesse caso quer que seja armazenado em string os valores dessa coluna.
	 */
	@Enumerated(EnumType.STRING)

	/*
	 * @Column vai descrever a coluna. O nome da coluna vai ser day e ela não vai
	 * ser nula.
	 */
	@Column(name = "day", nullable = false)
	private DayOfWeek dayOfWeek;

	/*
	 * Não faz sentido essa coluna poder assumir o valor nulo. ColumnDefinition
	 * define o tipo macro daquela coluna
	 */
	@Column(name = "end", nullable = false, columnDefinition = "Time")
	private Time endHour;

	@Column(name = "start", nullable = false, columnDefinition = "Time")
	private Time startHour;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private Professor professor;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private Course course;

	public Allocation() {
		super();
	}

	public Allocation(Long id, DayOfWeek dayOfWeek, Time endHour, Time startHour) {
		super();
		this.id = id;
		this.dayOfWeek = dayOfWeek;
		this.endHour = endHour;
		this.startHour = startHour;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Time getEndHour() {
		return endHour;
	}

	public void setEndHour(Time endHour) {
		this.endHour = endHour;
	}

	public Time getStartHour() {
		return startHour;
	}

	public void setStartHour(Time startHour) {
		this.startHour = startHour;
	}

}
