package pe.edu.upc.aweb_g08.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aweb_g08.dtos.PerfilSaludDTO;
import pe.edu.upc.aweb_g08.entities.PerfilSalud;
import java.util.List;

@Repository
public interface IPerfilSaludRepository extends JpaRepository<PerfilSalud, Integer> {

    @Query("SELECT new pe.edu.upc.aweb_g08.dtos.PerfilSaludDTO(" +
            "p.idPerfilSalud, p.peso, p.altura, p.nivelTrigliceridos, p.nivelColesterol, " +
            "p.fechaActualizacion, u.idUsuario, u.nombre) " +
            "FROM PerfilSalud p JOIN p.usuario u " +
            "WHERE p.nivelTrigliceridos > 150 OR p.nivelColesterol > 200")
    List<PerfilSaludDTO> listarUsuariosConPerfilAlterado();

    @Query("SELECT p FROM PerfilSalud p WHERE p.usuario.idUsuario = :idUsuario ORDER BY p.fechaActualizacion DESC")
    PerfilSalud obtenerUltimoPerfilPorUsuario(@Param("idUsuario") int idUsuario);

}

