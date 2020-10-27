package com.project.professor.allocation.model;

import java.sql.Time;
import java.time.DayOfWeek;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Entity sáo classes que mapeiam as tabelas no seu código. Essa classe é uma
		// entidade, ela representa uma tabela
@Table(name = "allocation") // identifica a tabela que ta sendo mapeada. O nome da tabela é allocation no db
public class Allocation {

	@Id // representa a coluna de Id da sua tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Vai ser uma ID de autoincremento
	private Long id;

	@Enumerated(EnumType.STRING) // Essa anotação informa o formato que você quer que seja armazenado na coluna,
									// nesse caso quer que seja armazenado em string os valores dessa coluna
	@Column(name = "day", nullable = false) // @Column vai descrever a coluna. O nome da coluna vai ser day e ela não
											// vai ser nula
	private DayOfWeek dayOfWeek;

	@Column(name = "end", nullable = false, columnDefinition = "Time") // não faz sentido essa coluna poder assumir o
																		// valor nulo. ColumnDefinition define o tipo
																		// macro daquela coluna
	private Time endHour;

	@Column(name = "start", nullable = false, columnDefinition = "Time")
	private Time startHour;

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

	public void setDay(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
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
