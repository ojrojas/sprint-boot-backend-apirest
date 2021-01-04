package com.bolsadeideas.sprintboot.backend.apirest.services;

import com.bolsadeideas.sprintboot.backend.apirest.models.Employee;

public interface IEmployeeService {
    Iterable<Employee> GetAll();

    Employee GetById(Long id);

    Employee Create(Employee employee);

    Employee Update(Employee employee, Long id);

    Employee Delete(Long id);    
}
