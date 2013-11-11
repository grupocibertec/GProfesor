package pe.edu.cibertec.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
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

    @Override
    public void insert(Profesor profesor) {
       em.persist(profesor);
    }

    @Override
    public void update(Profesor profesor) {
        em.merge(profesor);
    }

    @Override
    public void delete(Profesor profesor) {
        em.remove(profesor);
    }

}
