package com.bolsadeideas.sprintboot.backend.apirest.services;

import com.bolsadeideas.sprintboot.backend.apirest.dao.IEmployeeDao;
import com.bolsadeideas.sprintboot.backend.apirest.models.Employee;

import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeDao employeeDao;

    @Override
    public Iterable<Employee> GetAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee GetById(Long id) {
        return employeeDao.findById(id).orElse(null);
    }

    @Override
    public Employee Create(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    public Employee Update(Employee employee, Long id) {
        Employee EmployeePersistent = employeeDao.findById(id).get();
        EmployeePersistent.setNombre(employee.getNombre());
        EmployeePersistent.setCargo(employee.getCargo());
        EmployeePersistent.setSalario(employee.getSalario());
        EmployeePersistent.setTiempoCompleto(employee.getTiempoCompleto());
        EmployeePersistent.setDepartamento(employee.getDepartamento());
        return employeeDao.save(EmployeePersistent);
    }

    @Override
    public Employee Delete(Long id) {
        Employee employeePersistent = employeeDao.findById(id).get();
        employeeDao.delete(employeePersistent);
        return employeePersistent;
    }

}
