package com.bolsadeideas.sprintboot.backend.apirest.services;

import org.springframework.web.multipart.MultipartFile;

public interface IRepository<T> {

    Iterable<T> GetAll();
    
    Iterable<T> GetTake(int quantity);

    T GetById(Long id);

    T Create(T entity);

    T Update(T entity, Long id);

    T Delete(Long id);

    boolean ProcessReadFile(MultipartFile file);

    Long FindByName(String name);
}
