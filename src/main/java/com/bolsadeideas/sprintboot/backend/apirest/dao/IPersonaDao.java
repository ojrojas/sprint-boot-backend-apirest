package com.bolsadeideas.sprintboot.backend.apirest.dao;

import com.bolsadeideas.sprintboot.backend.apirest.models.Person;

import org.springframework.data.repository.CrudRepository;

public interface IPersonaDao extends CrudRepository<Person,Long> {

  

}