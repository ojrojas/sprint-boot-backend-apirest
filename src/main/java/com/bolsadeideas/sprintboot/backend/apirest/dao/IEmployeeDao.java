package com.bolsadeideas.sprintboot.backend.apirest.dao;

import java.util.List;

import com.bolsadeideas.sprintboot.backend.apirest.models.Employee;

import org.springframework.data.repository.CrudRepository;

public interface IEmployeeDao extends CrudRepository<Employee, Long> {
  
}
