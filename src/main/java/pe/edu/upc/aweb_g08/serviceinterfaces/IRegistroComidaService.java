package pe.edu.upc.aweb_g08.serviceinterfaces;

import pe.edu.upc.aweb_g08.entities.RegistroComida;

import java.time.LocalDate;
import java.util.List;

public interface IRegistroComidaService {
    List<RegistroComida> list();
    void delete(int id);
    RegistroComida listId(int id);
    void insert(RegistroComida registroComida);
    void update(RegistroComida registroComida);
    List<RegistroComida> listarPorReceta(int idReceta);
    List<RegistroComida> listarPorRangoDeFechas(LocalDate fechaInicio, LocalDate fechaFin);
}
