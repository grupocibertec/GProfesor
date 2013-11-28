package pe.edu.cibertec.action.prepare;

import com.opensymphony.xwork2.ActionContext;
import java.util.ResourceBundle;

public class NivelAcademico {

    private Character idNivelAcademico;
    private String nivelAcademico;

    public static final Character TECNICO = 'T';
    public static final Character SUPERIOR = 'S';
    public static final Character MASTER = 'M';

    private ResourceBundle labels;

    public NivelAcademico() {
    }

    public NivelAcademico(Character idNivelAcademico, ActionContext ctx) {
        this.idNivelAcademico = idNivelAcademico;

        labels = ResourceBundle.getBundle("language", ctx.getLocale());

        if (idNivelAcademico == TECNICO) {
            nivelAcademico = labels.getString("nivelAcademico.tecnico");
        } else if (idNivelAcademico == SUPERIOR) {
            nivelAcademico = labels.getString("nivelAcademico.superior");
        } else if (idNivelAcademico == MASTER) {
            nivelAcademico = labels.getString("nivelAcademico.master");
        } else {
            nivelAcademico = labels.getString("combo.noespecificado");
        }
    }

    public Character getIdNivelAcademico() {
        return idNivelAcademico;
    }

    public void setIdNivelAcademico(Character idNivelAcademico) {
        this.idNivelAcademico = idNivelAcademico;
    }

    public String getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(String nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

}
