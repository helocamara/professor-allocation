package com.project.professor.allocation.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.model.Course;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;

	@Test
	public void readAll() {
		List<Course> courses = courseRepository.findAll();

		for (Course course : courses) {
			System.out.println(course);
		}
	}

	@Test
	public void readById() {
		Course course = new Course();
		Long id = 1L;
		course = courseRepository.findById(id).orElse(null);
		System.out.println(course);
	}

	@Test
	public void create() {
		Course course = new Course();
		course.setId(null);
		course.setName("teste");
		course = courseRepository.save(course);
		System.out.println(course);
	}

	@Test
	public void update() {
		Course course = new Course();
		course.setId(2L);
		course.setName("Filosofia 1");
		course = courseRepository.save(course);
		System.out.println(course);
	}

	@Test
	public void deleteAll() {
		courseRepository.deleteAll();
	}

	@Test
	public void deleteById() {
		Long id = 3L;
		courseRepository.deleteById(id);

	}

}
