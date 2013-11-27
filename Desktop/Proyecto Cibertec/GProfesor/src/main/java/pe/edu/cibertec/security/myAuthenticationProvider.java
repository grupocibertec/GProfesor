/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.security;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.model.Rol;
import pe.edu.cibertec.model.Usuario;
import pe.edu.cibertec.service.UsuarioService;

/**
 *
 * @author ldiezcan
 */
@Component("myAuthenticationProvider")
public class myAuthenticationProvider implements AuthenticationProvider{

    @Autowired
    private UsuarioService usuarioService;
    
    @Override
    public Authentication authenticate(Authentication a) throws AuthenticationException {
        
        Usuario usuario = new Usuario();
        usuario.setNombre(a.getName());
        usuario.setClave(a.getCredentials().toString());
            
        usuario = usuarioService.validarCredenciales(usuario);
        
        if (usuario!=null)
        {
            List<GrantedAuthority> grantedAuths = new ArrayList();
            for (Rol rol : usuario.getRoles()) {
                grantedAuths.add(new SimpleGrantedAuthority(rol.getNombre()));
            }
            Authentication auth = new UsernamePasswordAuthenticationToken(usuario.getNombre(), usuario.getClave(), grantedAuths);
            return auth;
        }
        else
        {
            return null;
        }  
    
    }

    @Override
    public boolean supports(Class<?> type) {
       return type.equals(UsernamePasswordAuthenticationToken.class);
    }
    
}
