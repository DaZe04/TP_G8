package pe.edu.upc.aweb_g08.serviceinterfaces;

import pe.edu.upc.aweb_g08.dtos.AdminComentarioDTO;
import pe.edu.upc.aweb_g08.entities.Usuario;
import java.util.List;

public interface IUsuarioService {
    public List<Usuario> list();
    public void insert(Usuario usuario);
    public Usuario listId(int id);
    public void delete(int id);
    public void update(Usuario usuario);
    public List<Usuario> buscarService(String nombre);
    public List<AdminComentarioDTO> buscarAdminsConComentarios();

}
