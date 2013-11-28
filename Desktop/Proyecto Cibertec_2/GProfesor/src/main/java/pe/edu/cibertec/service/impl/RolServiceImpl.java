/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.dao.RolDao;
import pe.edu.cibertec.model.Rol;
import pe.edu.cibertec.service.RolService;

/**
 *
 * @author ldiezcan
 */
@Service("rolService")
public class RolServiceImpl implements RolService{

    @Autowired
    private RolDao rolDao;
    
    @Override
    public List<Rol> list() {
        return rolDao.list();
    }

    @Override
    public Rol getById(Integer id) {
        return rolDao.getById(id);
    }

    @Override
    @Transactional
    public void insert(Rol rol) {
        rolDao.insert(rol);
    }

    @Override
    @Transactional
    public void update(Rol rol) {
        rolDao.update(rol);
    }

    @Override
    @Transactional
    public void delete(Rol rol) {
        rol = rolDao.getById(rol.getId());
        rolDao.delete(rol);
    }
    
}
