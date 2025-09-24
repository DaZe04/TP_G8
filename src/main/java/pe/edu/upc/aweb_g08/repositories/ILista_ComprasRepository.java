package pe.edu.upc.aweb_g08.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aweb_g08.entities.Lista_Compras;

@Repository
public interface ILista_ComprasRepository  extends JpaRepository<Lista_Compras, Integer> {
}
