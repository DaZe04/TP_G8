package pe.edu.upc.aweb_g08.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aweb_g08.entities.Ingredientes;

import java.util.List;

@Repository
public interface IingredientesRepository extends JpaRepository<Ingredientes, Integer> {

    @Query(
            value = "SELECT CAST(nombre AS VARCHAR), CAST(calorias AS VARCHAR) FROM ingredientes ORDER BY calorias DESC LIMIT 5",
            nativeQuery = true
    )
    List<String[]> topIngredientesCaloricos();
}
