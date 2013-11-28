package pe.edu.cibertec.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.cibertec.action.prepare.EstadoProfesor;
import pe.edu.cibertec.action.prepare.Genero;
import pe.edu.cibertec.action.prepare.Modalidad;
import pe.edu.cibertec.action.prepare.NivelAcademico;
import pe.edu.cibertec.model.Profesor;
import pe.edu.cibertec.service.ProfesorService;

public class ProfesorAction extends ActionSupport implements Preparable {

    private List<Profesor> listadoProfesor;
    private Profesor profesor;
    private Integer id;

    //Usado para las fechas
    //-----------------------------------------
    private String fechaNacimiento;
    private String fechaRegistro;
    private String fechaIngreso;
    private String fechaActualizacion;
    //-----------------------------------------

    //Combos
    //---------------------------------------------------
    private List<Genero> listadoGenero;
    private List<EstadoProfesor> listadoEstadoProfesor;
    private List<Modalidad> listadoModalidad;
    private List<NivelAcademico> listadoNivelAcademico;
    //---------------------------------------------------

    SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");

    @Autowired
    ProfesorService profesorService;

    public String verListado() {
        listadoProfesor = profesorService.list();
        return SUCCESS;
    }

    public String paginaInsertar() {
        return SUCCESS;
    }

    public String paginaModificar() {
        obtenerProfesor();
        return SUCCESS;
    }

    public String verDetalle() {
        obtenerProfesor();
        return SUCCESS;
    }

    public String eliminar() {
        Profesor p = new Profesor();
        p.setIdProfesor(id);
        profesorService.delete(p);
        return SUCCESS;
    }

    public String insertarProfesor() {
        try {
            profesor.setFcNacimiento(sf.parse(fechaNacimiento));
            profesor.setFcIngreso(sf.parse(fechaIngreso));

            profesorService.insert(profesor);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return SUCCESS;
    }

    public String modificarProfesor() {
        try {
            profesor.setFcNacimiento(sf.parse(fechaNacimiento));
            profesor.setFcIngreso(sf.parse(fechaIngreso));

            profesorService.update(profesor);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return SUCCESS;
    }

    //METODOS DE APOYO
    //----------------------------------
     public void obtenerProfesor() {
        profesor = profesorService.getById(id);
        fechaNacimiento = profesor.getFcNacimiento() != null ? sf.format(profesor.getFcNacimiento()) : null;
        fechaIngreso = profesor.getFcIngreso() != null ? sf.format(profesor.getFcIngreso()) : null;  
     }
    //-----------------------------------
    //PREPARE, carga de combos
    @Override
    public void prepare() throws Exception {

        ActionContext ctx = ActionContext.getContext();
        listadoGenero = new ArrayList<Genero>();
        listadoGenero.add(new Genero(Genero.MASCULINO, ctx));
        listadoGenero.add(new Genero(Genero.FEMENINO, ctx));

        listadoEstadoProfesor = new ArrayList<EstadoProfesor>();
        listadoEstadoProfesor.add(new EstadoProfesor(EstadoProfesor.ACTIVO, ctx));
        listadoEstadoProfesor.add(new EstadoProfesor(EstadoProfesor.CAPACITACION, ctx));
        listadoEstadoProfesor.add(new EstadoProfesor(EstadoProfesor.INACTIVO, ctx));
        listadoEstadoProfesor.add(new EstadoProfesor(EstadoProfesor.VACACIONES, ctx));

        listadoModalidad = new ArrayList<Modalidad>();
        listadoModalidad.add(new Modalidad(Modalidad.TITULAR, ctx));
        listadoModalidad.add(new Modalidad(Modalidad.AGREGADO, ctx));
        listadoModalidad.add(new Modalidad(Modalidad.AYUDANTE, ctx));
        listadoModalidad.add(new Modalidad(Modalidad.INTERNO, ctx));

        listadoNivelAcademico = new ArrayList<NivelAcademico>();
        listadoNivelAcademico.add(new NivelAcademico(NivelAcademico.TECNICO, ctx));
        listadoNivelAcademico.add(new NivelAcademico(NivelAcademico.SUPERIOR, ctx));
        listadoNivelAcademico.add(new NivelAcademico(NivelAcademico.MASTER, ctx));

    }

    //GETTER AND SETTERS
    //--------------------------------------------------------
    public List<Profesor> getListadoProfesor() {
        return listadoProfesor;
    }

    public void setListadoProfesor(List<Profesor> listadoProfesor) {
        this.listadoProfesor = listadoProfesor;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Genero> getListadoGenero() {
        return listadoGenero;
    }

    public void setListadoGenero(List<Genero> listadoGenero) {
        this.listadoGenero = listadoGenero;
    }

    public List<EstadoProfesor> getListadoEstadoProfesor() {
        return listadoEstadoProfesor;
    }

    public void setListadoEstadoProfesor(List<EstadoProfesor> listadoEstadoProfesor) {
        this.listadoEstadoProfesor = listadoEstadoProfesor;
    }

    public List<Modalidad> getListadoModalidad() {
        return listadoModalidad;
    }

    public void setListadoModalidad(List<Modalidad> listadoModalidad) {
        this.listadoModalidad = listadoModalidad;
    }

    public List<NivelAcademico> getListadoNivelAcademico() {
        return listadoNivelAcademico;
    }

    public void setListadoNivelAcademico(List<NivelAcademico> listadoNivelAcademico) {
        this.listadoNivelAcademico = listadoNivelAcademico;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

}
