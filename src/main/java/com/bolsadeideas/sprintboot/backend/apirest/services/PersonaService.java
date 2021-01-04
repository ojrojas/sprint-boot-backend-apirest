package com.bolsadeideas.sprintboot.backend.apirest.services;

import com.bolsadeideas.sprintboot.backend.apirest.dao.IPersonaDao;
import com.bolsadeideas.sprintboot.backend.apirest.models.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonService {

    @Autowired
    private IPersonaDao personDao;
    @Override
    public Iterable<Person> GetAll() {
       return personDao.findAll();
    }

    @Override
    public Person GetById(Long id) {
        return personDao.findById(id).orElse(null);
    }

    @Override
    public Person Create(Person person) {
       return personDao.save(person);
    }

    @Override
    public Person Update(Person person, Long id) {
       Person personPersistent = personDao.findById(id).get(); 
       personPersistent.setLastName(person.getLastName());
       personPersistent.setName(person.getName());
       personPersistent.setEdad(person.getEdad());
       personPersistent.setIdentification(person.getIdentification());
       return personDao.save(personPersistent);
    }

    @Override
    public Person Delete(Long id) {
       var person =  personDao.findById(id);
       if(person != null)
        personDao.delete(person.get());
        return person.get();
    }
    
}
