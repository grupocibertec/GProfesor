package pe.edu.cibertec.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.dao.AuditoriaDao;
import pe.edu.cibertec.model.Auditoria;
import pe.edu.cibertec.service.AuditoriaService;

@Service("auditoriaService")
public class AuditoriaServiceImpl implements AuditoriaService{

    @Autowired
    AuditoriaDao dao;
    
    @Override
    public List<Auditoria> list() {
        return dao.list();
    }

    @Override
    public Auditoria getById(Integer id) {
       return dao.getById(id);
    }

    @Transactional
    @Override
    public void insert(Auditoria auditoria) {
        dao.insert(auditoria);
    }

    @Transactional
    @Override
    public void update(Auditoria auditoria) {
        dao.update(auditoria);
    }

    @Transactional
    @Override
    public void delete(Auditoria auditoria) {
        dao.delete(auditoria);
    }
    
}
