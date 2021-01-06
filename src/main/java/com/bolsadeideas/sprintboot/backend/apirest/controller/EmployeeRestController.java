package com.bolsadeideas.sprintboot.backend.apirest.controller;

import java.util.List;

import com.bolsadeideas.sprintboot.backend.apirest.models.Employee;
import com.bolsadeideas.sprintboot.backend.apirest.services.IRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;

@CrossOrigin(origins = "http://localhost:4200")
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

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("empleados/fileupload")
    public Boolean FileUpload(@RequestParam("archivo") MultipartFile archivo){
        return employeeService.ProcessReadFile(archivo);
    }

    @GetMapping("/empleados/take/{quantity}")
     public Iterable<Employee> GetById(@PathVariable Integer quantity) {
        return employeeService.GetTake(quantity);
    }
    
    @GetMapping("/empleados/SumSalaries")
     public Double SumSalaries() {
        List<Employee> empleados = (List<Employee>) employeeService.GetAll();
        return empleados.stream().mapToDouble(x -> x.getSalario()).sum();
    }
}
