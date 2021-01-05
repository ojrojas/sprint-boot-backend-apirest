package com.bolsadeideas.sprintboot.backend.apirest.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Personas")
public class Person implements Serializable {

    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String Name;
    private String LastName;
    private String Identification;
    private int Edad;

    public String getName() {
        return Name;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        this.Edad = edad;
    }

    public String getIdentification() {
        return Identification;
    }

    public void setIdentification(String identification) {
        this.Identification = identification;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setEntity(
         String name,
         String lastName,
         String identification,
         int edad) {
             this.Name = name;
             this.LastName = lastName;
             this.Identification = identification;
             this.Edad = edad;
         }



}
