package com.bolsadeideas.sprintboot.backend.apirest.controller;

import com.bolsadeideas.sprintboot.backend.apirest.models.Person;
import com.bolsadeideas.sprintboot.backend.apirest.services.IRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonRestController {

    @Autowired
    private IRepository<Person> personaService;

    @GetMapping("/personas")
    public Iterable<Person> Get() {
        return personaService.GetAll();
    }

    @PostMapping("/personas")
    @ResponseStatus(HttpStatus.CREATED)
    public Person Create(@RequestBody Person person) {
        return personaService.Create(person);
    }

    @PutMapping("/personas/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Person Update(@RequestBody Person person, @PathVariable Long id) {
        return personaService.Update(person, id );
    }

    @GetMapping("/personas/{id}")
    public Person GetById(@PathVariable Long id) {
        return personaService.GetById(id);
    }

    @DeleteMapping("/personas/{id}")
    public Person Delete(@PathVariable Long id) {
        return personaService.Delete(id);
    }
}
