package pe.edu.upc.aweb_g08.servicesinterfaces;

import pe.edu.upc.aweb_g08.entities.Recetas;

import java.util.List;

public interface IRecetasService {
    public List<Recetas> list();
    public void insert(Recetas recetas);
    public Recetas buscar(int id);
    public void delete(int id);
    public void update(Recetas recetas);
}
