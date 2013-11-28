/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.cibertec.model.Rol;
import pe.edu.cibertec.service.RolService;

/**
 *
 * @author ldiezcan
 */
public class RolAction extends ActionSupport{
    
    private List<Rol> listaRoles;
    
    private Rol rol;
    
    @Autowired
    private RolService rolService;

    private static final ResourceBundle labels = ResourceBundle.getBundle("language", ActionContext.getContext().getLocale());
    
    public List<Rol> getListaRoles() {
        return listaRoles;
    }

    public void setListaRoles(List<Rol> listaRoles) {
        this.listaRoles = listaRoles;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    public String listarRoles() throws Exception
    {
        listaRoles= rolService.list();
        return SUCCESS;
    }
    public String nuevoRol() 
    {
       
        rol = new Rol();
       
        return SUCCESS;
    }
    
    public String insertarRol()
    {
        rolService.insert(rol);
        return SUCCESS;
    }
    
    public String eliminarRol()
    {
        try {
            rolService.delete(rol); 
        } catch (Exception ex) {
            Logger.getLogger(RolAction.class.getName()).log(Level.SEVERE, null, ex);
            return "noautorizado";
        }

        return SUCCESS;
    }

    @Override
    public void validate() {
        super.validate(); //To change body of generated methods, choose Tools | Templates.
        
        if(rol!=null){
            if(rol.getNombre().trim().isEmpty()){
                addFieldError("rol.nombre",labels.getString("validacion.rol.nombre"));
            }
        }
        
    }
    
    
    
}
