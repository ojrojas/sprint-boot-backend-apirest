package com.bolsadeideas.sprintboot.backend.apirest.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employees")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String Nombre;
    private String Cargo;
    private String Salario;
    private String TiempoCompleto;
    private Long DepartamentoId;
    private Departament Departament;

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public String getNombre() {
        return Nombre;
    }

    public Long getDepartamentoId() {
        return DepartamentoId;
    }

    public void setDepartamentoId(Long departamentoId) {
        this.DepartamentoId = departamentoId;
    }

    public Departament getDepartament() {
        return Departament;
    }

    public void setDepartament(Departament departament) {
        this.Departament = departament;
    }

    public String getTiempoCompleto() {
        return TiempoCompleto;
    }

    public void setTiempoCompleto(String tiempoCompleto) {
        this.TiempoCompleto = tiempoCompleto;
    }

    public String getSalario() {
        return Salario;
    }

    public void setSalario(String salario) {
        this.Salario = salario;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String cargo) {
        this.Cargo = cargo;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public void SetEntity(
        String nombre,
        String cargo,
        String salario,
        String tiempoCompleto,
        Long departamentoId,
        Departament departament){
        this.Cargo = cargo;
        this.Nombre = nombre;
        this.Salario= salario;
        this.TiempoCompleto = tiempoCompleto;
        this.Departament = departament;
        this.DepartamentoId = departamentoId;
    }
}
