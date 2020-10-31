package com.project.professor.allocation.repository;

import java.sql.Time;
import java.time.DayOfWeek;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.model.Allocation;
import com.project.professor.allocation.model.Course;
import com.project.professor.allocation.model.Professor;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class AllocationRepositoryTest {

	@Autowired
	private AllocationRepository allocationRepository;

	@Test
	public void readAll() {
		List<Allocation> allocations = allocationRepository.findAll();
		for (Allocation allocation : allocations) {
			System.out.println(allocation);
		}
	}

	@Test
	public void readById() {
		Allocation allocation = new Allocation();
		Long id = 1L;
		allocation = allocationRepository.findById(id).orElse(null);
		System.out.println(allocation);
	}

	@Test
	public void create() {
		Professor professor = new Professor();
		professor.setId(10L);

		Course course = new Course();
		course.setId(2L);

		Allocation allocation = new Allocation();
		allocation.setId(null);
		allocation.setProfessor(professor);
		allocation.setCourse(course);
		allocation.setDayOfWeek(DayOfWeek.THURSDAY);
		allocation.setStartHour(Time.valueOf("08:00:00"));
		allocation.setEndHour(Time.valueOf("12:00:00"));
		allocation = allocationRepository.save(allocation);
		System.out.println(allocation);
	}

	@Test
	public void update() {
		Professor professor = new Professor();
		professor.setId(9L);

		Course course = new Course();
		course.setId(1L);

		Allocation allocation = new Allocation();
		allocation = allocationRepository.findById(1L).orElse(null);
		allocation.setProfessor(professor);
		allocation.setCourse(course);
		allocation.setDayOfWeek(DayOfWeek.MONDAY);
		allocation.setStartHour(Time.valueOf("09:00:00"));
		allocation.setEndHour(Time.valueOf("12:00:00"));
		allocation = allocationRepository.save(allocation);
		System.out.println(allocation);
	}

	@Test
	public void deleteAll() {
		allocationRepository.deleteAll();
	}

	@Test
	public void deleteById() {
		Long id = 3L;
		allocationRepository.deleteById(id);
	}

}
