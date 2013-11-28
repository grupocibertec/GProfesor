package pe.edu.cibertec.action.prepare;

import com.opensymphony.xwork2.ActionContext;
import java.util.ResourceBundle;

public class Modalidad {

    private Character idModalidad;
    private String modalidad;

    public static final Character TITULAR = 'T';
    public static final Character AGREGADO = 'A';
    public static final Character AYUDANTE = 'H';
    public static final Character INTERNO = 'I';

    private ResourceBundle labels;

    public Modalidad() {
    }

    public Modalidad(Character idModalidad, ActionContext ctx) {
        this.idModalidad = idModalidad;

        labels = ResourceBundle.getBundle("language", ctx.getLocale());
        if (idModalidad == TITULAR) {
            modalidad = labels.getString("modalidad.titular");
        } else if (idModalidad == AGREGADO) {
            modalidad = labels.getString("modalidad.agregado");
        } else if (idModalidad == AYUDANTE) {
            modalidad = labels.getString("modalidad.ayudante");
        } else if (idModalidad == INTERNO) {
            modalidad = labels.getString("modalidad.interno");
        } else {
            modalidad = labels.getString("combo.noespecificado");
        }
    }

    public Character getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(Character idModalidad) {
        this.idModalidad = idModalidad;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

}
