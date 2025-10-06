package pe.edu.upc.aweb_g08.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aweb_g08.entities.Recetas;

import java.util.List;


@Repository
public interface IRecetasRepository extends JpaRepository<Recetas, Integer> {

    @Query("SELECT r FROM Recetas r ORDER BY r.tiempoPreparacion DESC")
    List<Recetas> recetasMasLargas();

}
