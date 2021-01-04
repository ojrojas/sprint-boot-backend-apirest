package com.bolsadeideas.sprintboot.backend.apirest.dao;

import com.bolsadeideas.sprintboot.backend.apirest.models.Employee;

import org.springframework.data.repository.CrudRepository;

public interface IEmployeeDao extends CrudRepository<Employee, Long> {
}
