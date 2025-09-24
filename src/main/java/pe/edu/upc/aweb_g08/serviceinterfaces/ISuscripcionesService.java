package pe.edu.upc.aweb_g08.serviceinterfaces;

import pe.edu.upc.aweb_g08.entities.Suscripciones;

import java.util.List;

public interface ISuscripcionesService {
    public List<Suscripciones> list();
    public void insert(Suscripciones suscripciones);
    public Suscripciones buscar(int id);
    public void delete(int id);
    public void update(Suscripciones suscripciones);
}
