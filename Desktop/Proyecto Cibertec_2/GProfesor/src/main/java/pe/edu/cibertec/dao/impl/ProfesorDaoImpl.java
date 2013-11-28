package pe.edu.cibertec.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.dao.ProfesorDao;
import pe.edu.cibertec.model.Profesor;

@Repository("profesorDao")
public class ProfesorDaoImpl implements ProfesorDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Profesor> list() {
        Query q = em.createQuery("select a from Profesor a");
        return q.getResultList();
    }

    @Override
    public Profesor getById(Integer id) {
        Query q = em.createQuery("select a from Profesor a where a.idProfesor = :idProfesor");
        q.setParameter("idProfesor", id);
        return (Profesor) q.getSingleResult();
    }

    
    @Transactional
    @Override
    public Integer insert(Profesor profesor) {
        em.persist(profesor);
        return profesor.getIdProfesor();
    }

    @Transactional
    @Override
    public void update(Profesor profesor) {
        em.merge(profesor);
    }

    @Transactional
    @Override
    public void delete(Profesor profesor) {
        em.remove(profesor);
    }

}
