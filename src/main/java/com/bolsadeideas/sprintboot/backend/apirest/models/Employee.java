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
    private String Departamento;

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public String getNombre() {
        return Nombre;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String departamento) {
        this.Departamento = departamento;
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
}
