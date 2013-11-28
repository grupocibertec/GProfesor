package pe.edu.cibertec.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
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
    private String fechaIngreso;
    //-----------------------------------------

    //Combos
    //---------------------------------------------------
    private List<Genero> listadoGenero;
    private List<EstadoProfesor> listadoEstadoProfesor;
    private List<Modalidad> listadoModalidad;
    private List<NivelAcademico> listadoNivelAcademico;
    //---------------------------------------------------

    SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX
            = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static final ResourceBundle labels = ResourceBundle.getBundle("language", ActionContext.getContext().getLocale());

    @Autowired
    ProfesorService profesorService;

    public String verListado() {
        listadoProfesor = profesorService.list();
        return SUCCESS;
    }

    public String paginaInsertar() {
        profesor = new Profesor();
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
        try {
            profesorService.delete(p);
        } catch (AccessDeniedException e) {
            return "noAutorizado";
        }

        return SUCCESS;
    }

    public String insertarProfesor() {
        try {
            profesor.setFcNacimiento(sf.parse(fechaNacimiento));
            profesor.setFcIngreso(sf.parse(fechaIngreso));

            profesorService.insert(profesor);
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (AccessDeniedException e) {
            return "noAutorizado";
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
        } catch (AccessDeniedException e) {
            return "noAutorizado";
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

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public void validate() {

        if (profesor != null) {

            if (profesor.getNombre().trim().isEmpty()) {
                addFieldError("profesor.nombre", labels.getString("validacion.profesor.nombre"));
            }
            if (profesor.getApPaterno().trim().isEmpty()) {
                addFieldError("profesor.apPaterno", labels.getString("validacion.profesor.appaterno"));
            }
            if (profesor.getApMaterno().trim().isEmpty()) {
                addFieldError("profesor.apMaterno", labels.getString("validacion.profesor.apmaterno"));
            }
            if (profesor.getDni().trim().isEmpty()) {
                addFieldError("profesor.dni", labels.getString("validacion.profesor.dni.requerido"));
            } else if (profesor.getDni().trim().length() != 8) {
                addFieldError("profesor.dni", labels.getString("validacion.profesor.dni.longitud"));
            } else {
                try {
                    Integer.parseInt(profesor.getDni());
                } catch (NumberFormatException e) {
                    addFieldError("profesor.dni", labels.getString("validacion.profesor.dni.numeros"));
                }
            }
            if (fechaIngreso.trim().isEmpty()) {
                addFieldError("fechaIngreso", labels.getString("validacion.profesor.fechaIngreso"));
            }else{
                try {
                     sf.parse(fechaIngreso);
                } catch (ParseException e) {
                    addFieldError("fechaIngreso", labels.getString("validacion.profesor.fechaIngreso"));
                }
            }
            if (fechaNacimiento.trim().isEmpty()) {
                addFieldError("fechaNacimiento", labels.getString("validacion.profesor.fechaNacimiento"));
            }else{
                try {
                     sf.parse(fechaNacimiento);
                } catch (ParseException e) {
                    addFieldError("fechaNacimiento", labels.getString("validacion.profesor.fechaNacimiento"));
                }
            }
            if (profesor.getEstado().toString().trim().isEmpty()
                    || profesor.getEstado().toString().equalsIgnoreCase("-")) {
                addFieldError("profesor.estado", labels.getString("validacion.profesor.estado"));
            }
            if (profesor.getGenero().toString().trim().isEmpty()
                    || profesor.getGenero().toString().equalsIgnoreCase("-")) {
                addFieldError("profesor.genero", labels.getString("validacion.profesor.genero"));
            }
            if (profesor.getModalidad().toString().trim().isEmpty()
                    || profesor.getModalidad().toString().equalsIgnoreCase("-")) {
                addFieldError("profesor.modalidad", labels.getString("validacion.profesor.modalidad"));
            }
            if (profesor.getNivel().toString().trim().isEmpty()
                    || profesor.getNivel().toString().equalsIgnoreCase("-")) {
                addFieldError("profesor.nivel", labels.getString("validacion.profesor.nivel"));
            }

            if (profesor.getEmail().trim().length() > 0) {
                Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(profesor.getEmail());
                if (!matcher.find()) {
                    addFieldError("profesor.email", labels.getString("validacion.profesor.email"));
                }
            }
        }
    }

}
