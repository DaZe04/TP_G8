package pe.edu.upc.aweb_g08.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aweb_g08.entities.Lista_Compras;
import pe.edu.upc.aweb_g08.repositories.ILista_ComprasRepository;
import pe.edu.upc.aweb_g08.servicesinterfaces.ILista_ComprasService;

import java.util.List;
@Service
public class ILista_ComprasServiceImplement  implements ILista_ComprasService {

    @Autowired
    private ILista_ComprasRepository repository;

    @Override
    public List<Lista_Compras> list() {
        return repository.findAll();
    }

    @Override
    public void insert(Lista_Compras listaCompras) {
        repository.save(listaCompras);

    }

    @Override
    public Lista_Compras buscar(int id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {

        repository.deleteById(id);
    }

    @Override
    public void update(Lista_Compras listaCompras) {
        repository.save(listaCompras);
    }
}
