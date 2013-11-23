/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.dao.UsuarioDao;
import pe.edu.cibertec.model.Usuario;
import pe.edu.cibertec.service.UsuarioService;

/**
 *
 * @author ldiezcan
 */
@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioDao usuarioDao;
    
    @Override
    public List<Usuario> list() {
        return usuarioDao.list();
    }

    @Override
    public Usuario getByList(Integer id) {
        return usuarioDao.getByList(id);
    }

    @Override
    @Transactional
    public void insert(Usuario usuario) {
       usuarioDao.insert(usuario);
    }

    @Override
    @Transactional
    public void update(Usuario usuario) {
        usuarioDao.update(usuario);
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuario = usuarioDao.getByList(usuario.getId());
        usuarioDao.delete(usuario);
    }

    @Override
    public boolean validarCredenciales(Usuario usuario) {
        return usuarioDao.validarCredenciales(usuario);
    }
    
}
