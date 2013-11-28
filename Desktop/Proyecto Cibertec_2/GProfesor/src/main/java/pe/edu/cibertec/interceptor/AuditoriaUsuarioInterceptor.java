package pe.edu.cibertec.interceptor;

import java.util.Date;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.model.Auditoria;
import pe.edu.cibertec.model.Usuario;
import pe.edu.cibertec.service.AuditoriaService;

/**
 *
 * @author francisco
 */
@Aspect
@Component("auditoriaUsuarioInterceptor")
public class AuditoriaUsuarioInterceptor {
    
    @Autowired
    AuditoriaService service;
    
    //--------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------
    //-------------------------------AUDITORIA DE ELIMINACION-------------------------------
    //--------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------
    @Before("execution(* pe.edu.cibertec.dao.impl.UsuarioDaoImpl.delete(pe.edu.cibertec.model.Usuario)) && args(usuario)")
    public void beforeDeleteUsuarioInterceptor(Usuario usuario) {
        Auditoria auditoria = new Auditoria();
        auditoria.setFecha(new Date());
        auditoria.setDescripcion("Por Eliminar: " +usuario.getClass().getSimpleName()+": " + usuario.toString());
        service.insert(auditoria);
    }
    
    @After("execution(* pe.edu.cibertec.dao.impl.UsuarioDaoImpl.delete(pe.edu.cibertec.model.Usuario)) && args(usuario)")
    public void afterDeleteUsuarioInterceptor(Usuario usuario) {
        Auditoria auditoria = new Auditoria();
        auditoria.setFecha(new Date());
        auditoria.setDescripcion("Eliminado: " +usuario.getClass().getSimpleName()+": " + usuario.toString());
        service.insert(auditoria);
    }
    //--------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------
    //----------------------------AUDITORIA DE INSERCION------------------------------------
    //--------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------
    @Before("execution(* pe.edu.cibertec.dao.impl.UsuarioDaoImpl.insert(pe.edu.cibertec.model.Usuario)) && args(usuario)")
    public void beforeInsertUsuarioPointCut(Usuario usuario) {
        Auditoria auditoria = new Auditoria();
        auditoria.setFecha(new Date());
        auditoria.setDescripcion("Por Insertar: " +usuario.getClass().getSimpleName()+": " + usuario.toString());
        service.insert(auditoria);
    }
    
    @After("execution(* pe.edu.cibertec.dao.impl.UsuarioDaoImpl.insert(pe.edu.cibertec.model.Usuario)) && args(usuario)")
    public void afterInsertUsuarioInterceptor(Usuario usuario) {
        Auditoria auditoria = new Auditoria();
        auditoria.setFecha(new Date());
        auditoria.setDescripcion("Insertado: " +usuario.getClass().getSimpleName()+": " + usuario.toString());
        service.insert(auditoria);
    }
    //--------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------
    //----------------------------AUDITORIA DE ACTUALIZACION--------------------------------
    //--------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------
    @Before("execution(* pe.edu.cibertec.dao.impl.UsuarioDaoImpl.update(pe.edu.cibertec.model.Usuario)) && args(usuario)")
    public void beforeUpdateUsuarioPointCut(Usuario usuario) {
        Auditoria auditoria = new Auditoria();
        auditoria.setFecha(new Date());
        auditoria.setDescripcion("Por Actualizar: " +usuario.getClass().getSimpleName()+": " + usuario.toString());
        service.insert(auditoria);
    }
    
    @After("execution(* pe.edu.cibertec.dao.impl.UsuarioDaoImpl.update(pe.edu.cibertec.model.Usuario)) && args(usuario)")
    public void afterUpdateUsuarioInterceptor(Usuario usuario) {
        Auditoria auditoria = new Auditoria();
        auditoria.setFecha(new Date());
        auditoria.setDescripcion("Actualizado: "+usuario.getClass().getSimpleName()+": " + usuario.toString());
        service.insert(auditoria);
    }
    //--------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------
}
