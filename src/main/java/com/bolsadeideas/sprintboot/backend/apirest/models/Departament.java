package com.bolsadeideas.sprintboot.backend.apirest.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Departamento")
public class Departament implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String Name;

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

}
