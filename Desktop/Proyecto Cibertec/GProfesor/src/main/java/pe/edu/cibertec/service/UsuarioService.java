/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.service;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import pe.edu.cibertec.model.Usuario;

/**
 *
 * @author ldiezcan
 */
public interface UsuarioService {
    
    public List<Usuario> list();
    public Usuario getByList(Integer id);
    public void insert(Usuario usuario);
    public void update(Usuario usuario);
    @PreAuthorize("hasRole('ROLE_SUPER')")
    public void delete(Usuario usuario);
    public boolean validarCredenciales(Usuario usuario);
}
