package com.bolsadeideas.sprintboot.backend.apirest.services;

import java.io.InputStreamReader;
import java.util.List;

import com.bolsadeideas.sprintboot.backend.apirest.dao.IDepartamentDao;
import com.bolsadeideas.sprintboot.backend.apirest.models.Departament;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    @Override
    public boolean ProcessReadFile(MultipartFile File) {
        try {
            InputStreamReader reader = new InputStreamReader(File.getInputStream());
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
            List<String[]> rows = csvReader.readAll();
            for (String[] row : rows) {
                Long exist = this.FindByName(row[4]);
                if(exist == null){
                    departamentDao.save(new Departament(row[4]));
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Long FindByName(String name) {
        List<Departament> AllDepartaments = (List<Departament>) departamentDao.findAll();
        for(Departament departament : AllDepartaments){
            if(departament.getName().equals(name))
            return departament.getId();
        }
        return null;
    }

    @Override
    public Iterable<Departament> GetTake(int quantity) {
        // TODO Auto-generated method stub
        return null;
    }

   

}
