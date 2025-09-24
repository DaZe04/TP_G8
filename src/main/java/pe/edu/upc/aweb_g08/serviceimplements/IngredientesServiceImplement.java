package pe.edu.upc.aweb_g08.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aweb_g08.entities.Foro;
import pe.edu.upc.aweb_g08.entities.Ingredientes;
import pe.edu.upc.aweb_g08.repositories.IForoRepository;
import pe.edu.upc.aweb_g08.repositories.IingredientesRepository;
import pe.edu.upc.aweb_g08.serviceinterfaces.IingredientesService;

import java.util.List;

@Repository
public class IngredientesServiceImplement extends IingredientesService {

    @Autowired
    private IingredientesRepository iR;

    @Override
    public List<Ingredientes> list() {
        return iR.findAll();
    }

    @Override
    public void insert(Ingredientes ingredientes) {
        iR.save(ingredientes);
    }

    @Override
    public Ingredientes listId(int id) {
        return iR.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        iR.deleteById(id);
    }

    @Override
    public void update(Ingredientes ingredientes) {
        iR.save(ingredientes);
    }
}
