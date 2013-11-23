/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.service;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import pe.edu.cibertec.model.Rol;

/**
 *
 * @author ldiezcan
 */
public interface RolService {
    
    public List<Rol> list();
    public Rol getById(Integer id);
    public void insert(Rol rol);
    public void update(Rol rol);
    @PreAuthorize("hasRole('ROLE_SUPER')")
    public void delete(Rol rol);
}
