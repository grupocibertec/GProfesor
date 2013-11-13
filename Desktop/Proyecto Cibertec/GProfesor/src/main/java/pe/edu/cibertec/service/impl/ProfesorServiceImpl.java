package pe.edu.cibertec.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.dao.ProfesorDao;
import pe.edu.cibertec.model.Profesor;
import pe.edu.cibertec.service.ProfesorService;

@Repository("profesorService")
public class ProfesorServiceImpl implements ProfesorService {

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

    @Override
    @Transactional
    public Integer insert(Profesor profesor) {
        return dao.insert(profesor);
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
