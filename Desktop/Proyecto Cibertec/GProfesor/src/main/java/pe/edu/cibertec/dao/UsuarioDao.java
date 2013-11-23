/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.dao;

import java.util.List;
import pe.edu.cibertec.model.Usuario;


/**
 *
 * @author ldiezcan
 */
public interface UsuarioDao {
    
    public List<Usuario> list();
    public Usuario getByList(Integer id);
    public void insert(Usuario usuario);
    public void update(Usuario usuario);
    public void delete(Usuario usuario);
    public boolean validarCredenciales(Usuario usuario);
}
