package com.bolsadeideas.sprintboot.backend.apirest.services;

import com.bolsadeideas.sprintboot.backend.apirest.models.Person;

public interface IPersonService {
    Iterable<Person> GetAll();

    Person GetById(Long id);

    Person Create(Person person);

    Person Update(Person person, Long id);

    Person Delete(Long id);

}
