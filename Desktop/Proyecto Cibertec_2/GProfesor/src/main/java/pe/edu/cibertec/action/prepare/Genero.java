package pe.edu.cibertec.action.prepare;

import com.opensymphony.xwork2.ActionContext;
import java.util.ResourceBundle;

public class Genero {

    private Character idGenero;
    private String genero;

    public static final Character MASCULINO = 'M';
    public static final Character FEMENINO = 'F';

    private ResourceBundle labels;

    public Genero() {
    }

    public Genero(Character idGenero, ActionContext ctx) {
        this.idGenero = idGenero;
        labels = ResourceBundle.getBundle("language", ctx.getLocale());
        if (idGenero == MASCULINO) {
            genero = labels.getString("genero.masculino");
        } else if (idGenero == FEMENINO) {
            genero = labels.getString("genero.femenino");
        } else {
            genero = labels.getString("combo.noespecificado");
        }
    }

    public Character getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Character idGenero) {
        this.idGenero = idGenero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}
