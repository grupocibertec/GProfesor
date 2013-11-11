package pe.edu.cibertec.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.dao.ProfesorDao;
import pe.edu.cibertec.model.Profesor;
import pe.edu.cibertec.service.ProfesorService;

public class ProfesorServiceImpl implements ProfesorService{

    @Autowired
    ProfesorDao dao;
    
    @Override
    public List<Profesor> list() {
        return dao.list();
    }

    @Override
    public Profesor getById(Integer id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void insert(Profesor profesor) {
        dao.insert(profesor);
    }

    @Transactional
    @Override
    public void update(Profesor profesor) {
        dao.update(profesor);
    }

    @Transactional
    @Override
    public void delete(Profesor profesor) {
        dao.update(profesor);
    }
    
}
