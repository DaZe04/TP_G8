package pe.edu.upc.aweb_g08.serviceinterfaces;

import pe.edu.upc.aweb_g08.entities.Alertas;
import java.util.List;

public interface IAlertaService {
    public List<Alertas> list();
    public void insert(Alertas alerta);
    public Alertas listId(int id);
    public void delete(int id);
    public void update(Alertas alerta);
}
