package pe.edu.upc.aweb_g08.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aweb_g08.entities.Suscripciones;
@Repository
public interface ISuscripcionesRepository extends JpaRepository<Suscripciones, Integer> {
}
