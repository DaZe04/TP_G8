package pe.edu.upc.aweb_g08.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aweb_g08.entities.Receta_Recomendacion;

import java.util.List;

@Repository
public interface IRecetaRecomendacionRepository extends JpaRepository<Receta_Recomendacion, Integer> {

  @Query("SELECT r FROM Receta_Recomendacion r WHERE r.cantidad >= :minCantidad")
    List<Receta_Recomendacion> listarPorCantidadMinima(@Param("minCantidad") float minCantidad);
}
