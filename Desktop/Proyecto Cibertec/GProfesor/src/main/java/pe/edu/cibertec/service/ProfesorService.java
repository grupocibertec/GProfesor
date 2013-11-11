package pe.edu.cibertec.service;

import java.util.List;
import pe.edu.cibertec.model.Profesor;

public interface ProfesorService {

    public List<Profesor> list();

    public Profesor getById(Integer id);

    public void insert(Profesor profesor);

    public void update(Profesor profesor);

    public void delete(Profesor profesor);

}
