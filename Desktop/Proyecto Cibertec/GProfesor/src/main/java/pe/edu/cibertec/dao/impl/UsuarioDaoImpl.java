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
import pe.edu.cibertec.dao.UsuarioDao;
import pe.edu.cibertec.model.Usuario;

/**
 *
 * @author ldiezcan
 */
@Repository("usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Usuario> list() {
        Query q = em.createQuery("select u from Usuario u");
        return q.getResultList();
    }

    @Override
    public Usuario getByList(Integer id) {
        Query q = em.createQuery("select u from Usuario u where u.id = :idUsuario");
        q.setParameter("idUsuario", id);
        return (Usuario)q.getSingleResult();
    }

    @Override
    public void insert(Usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public void update(Usuario usuario) {
       em.merge(usuario);
    }

    @Override
    public void delete(Usuario usuario) {
        em.remove(usuario);
    }
    
    @Override
    public boolean validarCredenciales(Usuario usuario) {
         Query  q = em.createQuery("select u from Usuario u where u.nombre = :nombreUsuario and u.clave = :claveUsuario and u.activo=1");
         q.setParameter("nombreUsuario", usuario.getNombre());
         q.setParameter("claveUsuario", usuario.getClave());
         
         return  (q.getResultList().size() == 1);
         
         
    }
}
