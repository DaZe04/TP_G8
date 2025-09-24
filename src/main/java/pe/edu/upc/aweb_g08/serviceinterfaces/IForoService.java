package pe.edu.upc.aweb_g08.serviceinterfaces;

import pe.edu.upc.aweb_g08.entities.Foro;

import java.util.List;

public interface IForoService {
    public List<Foro> list();
    public void insert(Foro foro);
    public Foro listId(int id);
    public void delete(int id);
    public void update(Foro foro);
}
