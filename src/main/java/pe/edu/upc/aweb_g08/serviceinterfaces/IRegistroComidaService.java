package pe.edu.upc.aweb_g08.serviceinterfaces;

import pe.edu.upc.aweb_g08.entities.RegistroComida;
import java.util.List;

public interface IRegistroComidaService {
    List<RegistroComida> list();
    void delete(int id);
    RegistroComida listId(int id);
    void insert(RegistroComida registroComida);
}
