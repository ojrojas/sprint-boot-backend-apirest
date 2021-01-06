package com.bolsadeideas.sprintboot.backend.apirest.services;

import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.bolsadeideas.sprintboot.backend.apirest.dao.IDepartamentDao;
import com.bolsadeideas.sprintboot.backend.apirest.dao.IEmployeeDao;
import com.bolsadeideas.sprintboot.backend.apirest.models.Departament;
import com.bolsadeideas.sprintboot.backend.apirest.models.Employee;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EmployeeService implements IRepository<Employee> {

    @Autowired
    private IEmployeeDao employeeDao;

    @Autowired
    private IDepartamentDao departamentDao;

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
        EmployeePersistent.SetEntity(employee.getNombre(), employee.getCargo(), employee.getSalario(),
                employee.getTiempoCompleto(), employee.getDepartamentoId(), employee.getDepartament());
        return employeeDao.save(EmployeePersistent);
    }

    @Override
    public Employee Delete(Long id) {
        Employee employeePersistent = employeeDao.findById(id).get();
        employeeDao.delete(employeePersistent);
        return employeePersistent;
    }

    @Override
    public boolean ProcessReadFile(MultipartFile File) {
        try {
            InputStreamReader reader = new InputStreamReader(File.getInputStream());
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
            List<String[]> rows = csvReader.readAll();
            for (String[] row : rows) {
                Long departamentId = this.FindByName(row[4]);
                if (departamentId == null) {
                    Departament departamentPersist = departamentDao.save(new Departament(row[4]));
                    employeeDao.save(new Employee(row[0], row[1], Long.parseLong(row[2]), row[3], departamentPersist.getId()));
                } else {
                    employeeDao.save(new Employee(row[0], row[1], Long.parseLong(row[2]), row[3], departamentId));
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Long FindByName(String DepartamentName) {
        List<Departament> AllDepartaments = (List<Departament>) departamentDao.findAll();
        for (Departament departament : AllDepartaments) {
            if (departament.getName().equals(DepartamentName))
                return departament.getId();
        }
        return null;
    }

    @Override
    public Iterable<Employee> GetTake(int quantity) {
       List<Employee> employees = (List<Employee>) employeeDao.findAll();
       Collections.sort(employees, Collections.reverseOrder());
       List<Employee> emploresult = employees.stream()
       .limit(quantity).collect(Collectors.toList());
        return emploresult;
    }

}
