package pe.edu.cibertec.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.dao.AuditoriaDao;
import pe.edu.cibertec.model.Auditoria;

@Repository("auditoriaDao")
public class AuditoriaDaoImpl implements AuditoriaDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Auditoria> list() {
        Query q = em.createQuery("select a from Auditoria a");
        return q.getResultList();
    }

    @Override
    public Auditoria getById(Integer id) {
        Query q = em.createQuery("select a from Auditoria a where a.idAuditoria = :idAuditoria");
        q.setParameter("idAuditoria", id);
        return (Auditoria) q.getSingleResult();
    }

    @Transactional
    @Override
    public void insert(Auditoria auditoria) {
        em.persist(auditoria);
    }

    @Transactional
    @Override
    public void update(Auditoria auditoria) {
        em.merge(auditoria);
    }

    @Transactional
    @Override
    public void delete(Auditoria auditoria) {
        em.remove(auditoria);
    }

}
