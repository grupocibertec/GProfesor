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
import pe.edu.cibertec.model.Usuario;
import pe.edu.cibertec.service.RolService;
import pe.edu.cibertec.service.UsuarioService;

/**
 *
 * @author ldiezcan
 */
public class UsuarioAction extends ActionSupport {

    private List<Usuario> listaUsuarios;
    private List<Rol> listaRoles;
    private Usuario usuario;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;

    private static final ResourceBundle labels = ResourceBundle.getBundle("language", ActionContext.getContext().getLocale());

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public List<Rol> getListaRoles() {
        return listaRoles;
    }

    public void setListaRoles(List<Rol> listaRoles) {
        this.listaRoles = listaRoles;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String listarUsuarios() throws Exception {
        listaUsuarios = usuarioService.list();
        return SUCCESS;
    }

    public String nuevoUsuario() {

        listaRoles = rolService.list();
        usuario = new Usuario();

        return SUCCESS;
    }

    public String insertarUsuario() {
        usuarioService.insert(usuario);
        return SUCCESS;
    }

    public String eliminarUsuario() {
        try {
            usuarioService.delete(usuario);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioAction.class.getName()).log(Level.SEVERE, null, ex);
            return "noautorizado";
        }

        return SUCCESS;
    }

    @Override
    public void validate() {
        super.validate();

        if (usuario != null) {

            if (usuario.getNombre().trim().isEmpty()) {
                addFieldError("usuario.nombre", labels.getString("validacion.usuario.nombre"));
            }
            if (usuario.getClave().trim().isEmpty()) {
                addFieldError("usuario.clave", labels.getString("validacion.usuario.clave"));
            }
            if (usuario.getRoles().size() < 1) {
                addFieldError("usuario.roles.id", labels.getString("validacion.usuario.roles"));
            }

        }

    }

}
