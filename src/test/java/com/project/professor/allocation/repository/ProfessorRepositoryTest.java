package com.project.professor.allocation.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.model.Professor;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class ProfessorRepositoryTest {

	@Autowired
	private ProfessorRepository professorRepository;
	
	@Test
	public void readAll() {
		List<Professor> professors = professorRepository.findAll();
		for (Professor professor: professors) {
			System.out.println(professor.toString());
		}
	}
	
	@Test
	public void readById() {
		Long id = 3L;
		Optional<Professor> optionalProfessor = professorRepository.findById(id);
		Professor professor = optionalProfessor.orElse(null);
		System.out.println(professor);
	}
}
