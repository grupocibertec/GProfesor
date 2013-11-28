/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.dao;

import java.util.List;
import pe.edu.cibertec.model.Rol;

/**
 *
 * @author ldiezcan
 */
public interface RolDao {
    
    public List<Rol> list();
    public Rol getById(Integer id);
    public void insert(Rol rol);
    public void update(Rol rol);
    public void delete(Rol rol);

}
