package com.bolsadeideas.sprintboot.backend.apirest.services;

import com.bolsadeideas.sprintboot.backend.apirest.dao.IDepartamentDao;
import com.bolsadeideas.sprintboot.backend.apirest.models.Departament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartamentService implements IRepository<Departament> {

    @Autowired
    private IDepartamentDao departamentDao;

    @Override
    public Iterable<Departament> GetAll() {
        return departamentDao.findAll();
    }

    @Override
    public Departament GetById(Long id) {
        return departamentDao.findById(id).orElse(null);
    }

    @Override
    public Departament Create(Departament entity) {
        return departamentDao.save(entity);
    }

    @Override
    public Departament Update(Departament entity, Long id) {
        Departament departamentPersist = this.GetById(id);
        if (departamentPersist != null) {
            departamentPersist.setName(entity.getName());
            return departamentDao.save(departamentPersist);
        } else
            return null;
    }

    @Override
    public Departament Delete(Long id) {
        Departament departamentPersist = this.GetById(id);
        departamentDao.delete(departamentPersist);
        return departamentPersist;
    }

}
