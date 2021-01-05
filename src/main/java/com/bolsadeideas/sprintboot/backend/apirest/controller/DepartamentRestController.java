package com.bolsadeideas.sprintboot.backend.apirest.controller;

import com.bolsadeideas.sprintboot.backend.apirest.models.Departament;
import com.bolsadeideas.sprintboot.backend.apirest.services.IRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api")
public class DepartamentRestController {
    
    @Autowired
    private IRepository<Departament> departamentService;

    @GetMapping("/departamentos")
    public Iterable<Departament> Get() {
        return departamentService.GetAll();
    }

    @PostMapping("/departamentos")
    @ResponseStatus(HttpStatus.CREATED)
    public Departament Create(@RequestBody Departament departament) {
        return departamentService.Create(departament);
    }

    @PutMapping("/departamentos/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Departament Update(@RequestBody Departament  departament, @PathVariable Long id) {
        return departamentService.Update(departament, id );
    }

    @GetMapping("/departamentos/{id}")
    public Departament GetById(@PathVariable Long id) {
        return departamentService.GetById(id);
    }

    @DeleteMapping("/departamentos/{id}")
    public Departament Delete(@PathVariable Long id) {
        return departamentService.Delete(id);
    }
}
