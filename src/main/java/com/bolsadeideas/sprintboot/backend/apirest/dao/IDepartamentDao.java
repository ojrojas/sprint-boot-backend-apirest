package com.bolsadeideas.sprintboot.backend.apirest.dao;

import com.bolsadeideas.sprintboot.backend.apirest.models.Departament;
import org.springframework.data.repository.CrudRepository;

public interface IDepartamentDao extends CrudRepository<Departament, Long> {
    
}
