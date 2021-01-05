package com.bolsadeideas.sprintboot.backend.apirest.controller;

import com.bolsadeideas.sprintboot.backend.apirest.models.Employee;
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
public class EmployeeRestController {
    
    @Autowired
    private IRepository<Employee> employeeService;

    @GetMapping("/empleados")
    public Iterable<Employee> Get() {
        return employeeService.GetAll();
    }

    @PostMapping("/empleados")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee Create(@RequestBody Employee person) {
        return employeeService.Create(person);
    }

    @PutMapping("/empleados/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee Update(@RequestBody Employee person, @PathVariable Long id) {
        return employeeService.Update(person, id );
    }

    @GetMapping("/empleados/{id}")
    public Employee GetById(@PathVariable Long id) {
        return employeeService.GetById(id);
    }

    @DeleteMapping("/empleados/{id}")
    public Employee Delete(@PathVariable Long id) {
        return employeeService.Delete(id);
    }




}
