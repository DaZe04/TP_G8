package pe.edu.upc.aweb_g08.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aweb_g08.entities.Suscripciones;

import java.util.List;

@Repository
public interface ISuscripcionesRepository extends JpaRepository<Suscripciones, Integer> {
    @Query(value = "SELECT s.tipo, COUNT(s.id_suscripciones) AS total_usuarios\n" +
            "FROM Suscripciones s\n" +
            "WHERE s.estado = 'Activo'\n" +
            "GROUP BY s.tipo\n" +
            "ORDER BY total_usuarios DESC;\n",nativeQuery = true)
    public List<String[]> quantitytypebySuscripciones();


    @Query(value = "SELECT s.tipo, \n" +
            "       COUNT(d.id_dispositivo) AS total_dispositivos\n" +
            "FROM suscripciones s\n" +
            "INNER JOIN usuario u ON s.id_usuario = u.id_usuario\n" +
            "INNER JOIN dispositivos d ON u.id_usuario = d.id_usuario\n" +
            "WHERE s.estado = 'Activo'\n" +
            "GROUP BY s.tipo\n" +
            "ORDER BY total_dispositivos DESC;",nativeQuery = true)
    public List<String[]> quantityDevicebySuscripciones();
}
