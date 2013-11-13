package pe.edu.cibertec.action.prepare;

import com.opensymphony.xwork2.ActionContext;
import java.util.ResourceBundle;

public class EstadoProfesor {

    private Character idEstadoProfesor;
    private String estadoProfesor;

    public static final Character ACTIVO = 'A';
    public static final Character INACTIVO = 'I';
    public static final Character CAPACITACION = 'C';
    public static final Character VACACIONES = 'V';

    private ResourceBundle labels;

    public EstadoProfesor() {
    }

    public EstadoProfesor(Character idEstadoProfesor, ActionContext ctx) {
        this.idEstadoProfesor = idEstadoProfesor;

        labels = ResourceBundle.getBundle("language", ctx.getLocale());

        if (idEstadoProfesor == ACTIVO) {
            estadoProfesor = labels.getString("estadoProfesor.activo");
        } else if (idEstadoProfesor == INACTIVO) {
            estadoProfesor = labels.getString("estadoProfesor.inactivo");
        } else if (idEstadoProfesor == CAPACITACION) {
            estadoProfesor = labels.getString("estadoProfesor.capacitacion");
        } else if (idEstadoProfesor == VACACIONES) {
            estadoProfesor = labels.getString("estadoProfesor.vacaciones");
        } else {
            estadoProfesor = labels.getString("combo.noespecificado");
        }
    }

    public Character getIdEstadoProfesor() {
        return idEstadoProfesor;
    }

    public void setIdEstadoProfesor(Character idEstadoProfesor) {
        this.idEstadoProfesor = idEstadoProfesor;
    }

    public String getEstadoProfesor() {
        return estadoProfesor;
    }

    public void setEstadoProfesor(String estadoProfesor) {
        this.estadoProfesor = estadoProfesor;
    }

}
