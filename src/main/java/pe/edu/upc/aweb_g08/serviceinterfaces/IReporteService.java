package pe.edu.upc.aweb_g08.serviceinterfaces;

import pe.edu.upc.aweb_g08.entities.Reportes;
import java.util.List;

public interface IReporteService {
    public List<Reportes> list();
    public void insert(Reportes reporte);
    public Reportes listId(int id);
    public void delete(int id);
    public void update(Reportes reporte);
}
