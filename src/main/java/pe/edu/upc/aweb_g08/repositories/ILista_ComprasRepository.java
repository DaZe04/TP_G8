package pe.edu.upc.aweb_g08.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aweb_g08.entities.Lista_Compras;

import java.util.List;

@Repository
public interface ILista_ComprasRepository  extends JpaRepository<Lista_Compras, Integer> {
    @Query("SELECT l.fechaCreacionLista, SUM(l.cantidad) " +
            "FROM Lista_Compras l " +
            "GROUP BY l.fechaCreacionLista " +
            "ORDER BY SUM(l.cantidad) DESC")
    List<Object[]> listasDeComprasMasGrandes();
}
