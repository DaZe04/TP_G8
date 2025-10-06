package pe.edu.upc.aweb_g08.serviceinterfaces;

import pe.edu.upc.aweb_g08.dtos.PerfilSaludDTO;
import pe.edu.upc.aweb_g08.entities.PerfilSalud;
import java.util.List;

public interface IPerfilSaludService {
    public List<PerfilSalud> list();
    public void insert(PerfilSalud perfilSalud);
    public PerfilSalud listId(int id);
    public void delete(int id);
    public void update(PerfilSalud perfilSalud);
    public PerfilSalud obtenerUltimoPerfilPorUsuario(int idUsuario);
}
