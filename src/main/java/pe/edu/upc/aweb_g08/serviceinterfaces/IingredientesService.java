package pe.edu.upc.aweb_g08.serviceinterfaces;

import pe.edu.upc.aweb_g08.entities.Ingredientes;

import java.util.List;

public interface IingredientesService {
    public List<Ingredientes> list();
    public void insert(Ingredientes ingredientes);
    public Ingredientes listId(int id);
    public void delete(int id);
    public void update(Ingredientes ingredientes);
    public List<String[]> topIngredientesCaloricos();
}
