package pe.edu.upc.aweb_g08.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aweb_g08.dtos.AdminComentarioDTO;
import pe.edu.upc.aweb_g08.entities.Usuario;
import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query("select u from Usuario u where u.nombre like %:nombre%")
    public List<Usuario> buscarService(@Param("nombre") String nombre);

    @Query("SELECT new pe.edu.upc.aweb_g08.dtos.AdminComentarioDTO(u.idUsuario, u.nombre, u.apellido, c.contenido) " +
            "FROM Usuario u " +
            "JOIN u.rol r " +
            "JOIN u.comentarios c " +
            "WHERE r.idRol = 1 AND UPPER(r.nombre) = 'ADMIN'")
    List<AdminComentarioDTO> buscarAdminsConComentarios();

    @Query(value =
            "SELECT u.nombre, u.apellido, COUNT(rc.id_registro) AS total_registros " +
                    "FROM usuario u " +
                    "INNER JOIN registro_comidas rc ON rc.id_usuario = u.id_usuario " +
                    "GROUP BY u.nombre, u.apellido " +
                    "ORDER BY total_registros DESC " +
                    "LIMIT 5",
            nativeQuery = true)
    public List<String[]> usuariosMasActivos();
}








