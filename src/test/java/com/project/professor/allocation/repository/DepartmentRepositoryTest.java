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

import com.project.professor.allocation.model.Department;
/*
 * Test é apenas um artificio para que fosse possível testar a camada de repositorio 
 * sem que ela e a camada de serviço estejam prontas
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")

public class DepartmentRepositoryTest {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Test
	public void readAll() {
		List<Department> departments = departmentRepository.findAll();

		for (Department department : departments) {
			System.out.println(department);
		}
	}

	@Test
	public void readById() {
		// Esta procurando o id 1
		Long id = 1L;
		/*
		 * Permite que voce busque no banco pelo id (finByID) O Optional permite que
		 * voce defina o que retornar quando nao existe aquilo que vc esta procurando.
		 * Ex: um departamento de id 1, se nao existir ele retorna null
		 */
		Optional<Department> optionalDepartment = departmentRepository.findById(id);

		Department department = optionalDepartment.orElse(null);

		System.out.println(department);
	}

	@Test
	public void create() {
		Department department = new Department();
		/*
		 * O id colocou null pois ele é auto_increment, entao nao importa qual valor eu
		 * coloque ai, ele vai ignorar e continuar na ordem do auto_increment
		 */
		department.setId(null);
		department.setName("Departamento de Filosofia");

		department = departmentRepository.save(department);
		System.out.println(department);
	}
	
	/*
	 * Se for pra usar create, garante que o id é null no começo, se não pode ser
	 * que voce salve por cima de um id que já exista. Vai fazer um update.
	 */

	@Test
	public void update() {
		Department department = new Department();
		/*
		 * O id colocou null pois ele é auto_increment, entao nao importa qual valor eu
		 * coloque ai, ele vai ignorar e continuar na ordem do auto_increment
		 */
		department = departmentRepository.findById(2L).orElse(null);
		department.setId(2L);
		department.setName("Departamento de Filosofia");

		department = departmentRepository.save(department);
		System.out.println(department);
	}

	@Test
	public void deleteAll() {
		/*
		 * O deleteAllInBatch vai deletar tudo de uma vez
		 */
		departmentRepository.deleteAllInBatch();
	}
	
	@Test
	public void deleteById() {
		Long id = 1L;
		departmentRepository.deleteById(id);
	}
}
