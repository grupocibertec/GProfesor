package pe.edu.cibertec.interceptor;

import java.util.Date;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.model.Auditoria;
import pe.edu.cibertec.model.Profesor;
import pe.edu.cibertec.service.AuditoriaService;

/**
 *
 * @author francisco
 */
@Aspect
@Component("auditoriaProfesorInterceptor")
public class AuditoriaProfesorInterceptor {
    
    @Autowired
    private AuditoriaService service;
    
    Logger log = Logger.getLogger(AuditoriaProfesorInterceptor.class);
    //--------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------
    //-------------------------------AUDITORIA DE ELIMINACION-------------------------------
    //--------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------
    @Before("execution(* pe.edu.cibertec.dao.impl.ProfesorDaoImpl.delete(pe.edu.cibertec.model.Profesor)) && args(profesor)")
    public void beforeDeleteProfeInterceptor(Profesor profesor) {
        Auditoria auditoria = new Auditoria();
        auditoria.setFecha(new Date());
        BasicConfigurator.configure();
        log.info("Por Eliminar: "+profesor.getClass().getSimpleName()+": " + profesor.toString());
        BasicConfigurator.resetConfiguration();
        auditoria.setDescripcion("Por Eliminar: "+profesor.getClass().getSimpleName()+": " + profesor.toString());
        service.insert(auditoria);
    }
    
    @After("execution(* pe.edu.cibertec.dao.impl.ProfesorDaoImpl.delete(pe.edu.cibertec.model.Profesor)) && args(profesor)")
    public void afterDeleteProfeInterceptor(Profesor profesor) {
        Auditoria auditoria = new Auditoria();
        auditoria.setFecha(new Date());
        BasicConfigurator.configure();
        log.info("Eliminado: "+profesor.getClass().getSimpleName()+": " + profesor.toString());
        BasicConfigurator.resetConfiguration();
        auditoria.setDescripcion("Eliminado: "+profesor.getClass().getSimpleName()+": " + profesor.toString());
        service.insert(auditoria);
    }
    //--------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------
    //----------------------------AUDITORIA DE INSERCION------------------------------------
    //--------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------
    @Before("execution(* pe.edu.cibertec.dao.impl.ProfesorDaoImpl.insert(pe.edu.cibertec.model.Profesor)) && args(profesor)")
    public void beforeInsertProfePointCut(Profesor profesor) {
        Auditoria auditoria = new Auditoria();
        auditoria.setFecha(new Date());
        BasicConfigurator.configure();
        log.info("Por Insertar: "+profesor.getClass().getSimpleName()+": " + profesor.toString());
        BasicConfigurator.resetConfiguration();
        auditoria.setDescripcion("Por Insertar: " +profesor.getClass().getSimpleName()+": "+ profesor.toString());
        service.insert(auditoria);
    }
    
    @After("execution(* pe.edu.cibertec.dao.impl.ProfesorDaoImpl.insert(pe.edu.cibertec.model.Profesor)) && args(profesor)")
    public void afterInsertProfeInterceptor(Profesor profesor) {
        Auditoria auditoria = new Auditoria();
        auditoria.setFecha(new Date());
        BasicConfigurator.configure();
        log.info("Insertado: "+profesor.getClass().getSimpleName()+": " + profesor.toString());
        BasicConfigurator.resetConfiguration();
        auditoria.setDescripcion("Insertado: " +profesor.getClass().getSimpleName()+": "+ profesor.toString());
        service.insert(auditoria);
    }
    //--------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------
    //----------------------------AUDITORIA DE ACTUALIZACION--------------------------------
    //--------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------
    @Before("execution(* pe.edu.cibertec.dao.impl.ProfesorDaoImpl.update(pe.edu.cibertec.model.Profesor)) && args(profesor)")
    public void beforeUpdateProfePointCut(Profesor profesor) {
        Auditoria auditoria = new Auditoria();
        auditoria.setFecha(new Date());
        BasicConfigurator.configure();
        log.info("Por Actualizar: "+profesor.getClass().getSimpleName()+": " + profesor.toString());
        BasicConfigurator.resetConfiguration();
        auditoria.setDescripcion("Por Actualizar: "+profesor.getClass().getSimpleName()+": " + profesor.toString());
        service.insert(auditoria);
    }
    
    @After("execution(* pe.edu.cibertec.dao.impl.ProfesorDaoImpl.update(pe.edu.cibertec.model.Profesor)) && args(profesor)")
    public void afterUpdateProfeInterceptor(Profesor profesor) {
        Auditoria auditoria = new Auditoria();
        auditoria.setFecha(new Date());
        BasicConfigurator.configure();
        log.info("Actualizado: "+profesor.getClass().getSimpleName()+": " + profesor.toString());
        BasicConfigurator.resetConfiguration();
        auditoria.setDescripcion("Actualizado: " +profesor.getClass().getSimpleName()+": "+ profesor.toString());
        service.insert(auditoria);
    }
    //--------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------
}
