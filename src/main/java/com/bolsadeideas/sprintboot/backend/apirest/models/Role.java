package com.bolsadeideas.sprintboot.backend.apirest.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Role implements Serializable{
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
}
