package pe.edu.upc.aweb_g08.servicesinterfaces;

import pe.edu.upc.aweb_g08.entities.Dispositivos;

import java.util.List;

public interface IDispositivosService {
    public List<Dispositivos> list();
    public void insert(Dispositivos dispositivo);
    public Dispositivos buscar(int id);
    public void delete(int id);
    public void update(Dispositivos dispositivo);
}
