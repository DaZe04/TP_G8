package pe.edu.upc.aweb_g08.serviceinterfaces;

import pe.edu.upc.aweb_g08.entities.RegistroComida;
import java.util.List;

public interface IRegistroComidaService {
    List<RegistroComida> list();
    void insert(RegistroComida registroComida);
    void delete(int id);
    RegistroComida listId(int id);
    void update(RegistroComida registroComida);
    List<RegistroComida> listarPorReceta(int idReceta);
    List<RegistroComida> listarPorRangoDeFechas(LocalDate fechaInicio, LocalDate fechaFin);
}
