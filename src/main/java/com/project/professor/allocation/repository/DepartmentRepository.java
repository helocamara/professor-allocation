package com.project.professor.allocation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.professor.allocation.model.Department;

/*
 * @RRepository - Especificando pro spring que DepartmentRepository é um repositório
 * Primeiro vc indica pra que entidade essa interface vai funcionar (Department).
 * Long indica o formato do id da Entidade Department
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
