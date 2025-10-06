package pe.edu.upc.aweb_g08.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aweb_g08.entities.RegistroComida;

@Repository
public interface IRegistroComidaRepository extends JpaRepository<RegistroComida, Integer>{

    @Query("SELECT r FROM RegistroComida r WHERE r.recetas.idRecetas = :idReceta")
    List<RegistroComida> listarPorReceta(@Param("idReceta") int idReceta);

    @Query("SELECT r FROM RegistroComida r WHERE r.fechaConsumo BETWEEN :fechaInicio AND :fechaFin")
    List<RegistroComida> listarPorRangoDeFechas( @Param("inicio") LocalDate inicio,
                                                 @Param("fin") LocalDate fin
    );
}
