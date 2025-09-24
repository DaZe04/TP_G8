package pe.edu.upc.aweb_g08.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aweb_g08.entities.Recetas;
import pe.edu.upc.aweb_g08.repositories.IRecetasRepository;
import pe.edu.upc.aweb_g08.serviceinterfaces.IRecetasService;

import java.util.List;
@Service
public class IRecetasServiceImplement  implements IRecetasService  {

    @Autowired
    private IRecetasRepository  repository;


    @Override
    public List<Recetas> list() {
        return repository.findAll();
    }

    @Override
    public void insert(Recetas recetas) {
        repository.save(recetas);
    }


    @Override
    public Recetas  buscar(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Recetas recetas) {
        repository.save(recetas);

    }
}
