package pe.edu.cibertec.service;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import pe.edu.cibertec.model.Profesor;

public interface ProfesorService {

    public List<Profesor> list();

    public Profesor getById(Integer id);

    public Integer insert(Profesor profesor);

    public void update(Profesor profesor);
    @PreAuthorize("hasRole('ROLE_SUPER')")
    public void delete(Profesor profesor);

}
