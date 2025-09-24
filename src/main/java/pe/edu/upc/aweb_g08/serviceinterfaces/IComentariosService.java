package pe.edu.upc.aweb_g08.serviceinterfaces;

import pe.edu.upc.aweb_g08.entities.Comentarios;

import java.util.List;
//<>
public interface IComentariosService {
    public List<Comentarios> list();
    public void insert(Comentarios comentarios);
    public Comentarios listId(int id);
    public void delete(int id);
    public void update(Comentarios comentarios);
}
