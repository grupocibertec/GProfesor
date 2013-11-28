/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.dao.RolDao;
import pe.edu.cibertec.model.Rol;

/**
 *
 * @author ldiezcan
 */
@Repository("rolDao")
public class RolDaoImpl implements RolDao{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Rol> list() {
        Query q = em.createQuery("select r from Rol r");
        return q.getResultList();
    }

    @Override
    public Rol getById(Integer id) {
        Query q = em.createQuery("select r from Rol r where r.id = :idRol");
        q.setParameter("idRol", id);
        return (Rol)q.getSingleResult();
    }

    @Override
    public void insert(Rol rol) {
        em.persist(rol);
    }

    @Override
    public void update(Rol rol) {
        em.merge(em);
    }

    @Override
    public void delete(Rol rol) {
        em.remove(rol);
    }

    
}
