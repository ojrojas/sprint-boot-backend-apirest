package com.bolsadeideas.sprintboot.backend.apirest.services;

import com.bolsadeideas.sprintboot.backend.apirest.dao.IPersonaDao;
import com.bolsadeideas.sprintboot.backend.apirest.models.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PersonaService implements IRepository<Person> {

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
      personPersistent.setEntity(person.getName(), person.getLastName(), person.getIdentification(), person.getEdad());
      return personDao.save(personPersistent);
   }

   @Override
   public Person Delete(Long id) {
      var person = personDao.findById(id);
      if (person != null)
         personDao.delete(person.get());
      return person.get();
   }

   @Override
   public boolean ProcessReadFile(MultipartFile file) {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public Long FindByName(String name) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public Iterable<Person> GetTake(int quantity) {
      // TODO Auto-generated method stub
      return null;
   }

}
