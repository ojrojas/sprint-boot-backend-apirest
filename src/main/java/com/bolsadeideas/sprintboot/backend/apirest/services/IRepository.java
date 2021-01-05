package com.bolsadeideas.sprintboot.backend.apirest.services;

public interface IRepository<T> {

    Iterable<T> GetAll();

    T GetById(Long id);

    T Create(T entity);

    T Update(T entity, Long id);

    T Delete(Long id);

}
