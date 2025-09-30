package pe.edu.upc.aweb_g08.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aweb_g08.entities.Suscripciones;
import pe.edu.upc.aweb_g08.repositories.ISuscripcionesRepository;
import pe.edu.upc.aweb_g08.serviceinterfaces.ISuscripcionesService;

import java.util.List;
@Service
public class ISucripcionesServiceImplement implements ISuscripcionesService {

    @Autowired
    private ISuscripcionesRepository repository;

    @Override
    public List<Suscripciones> list() {
        return repository.findAll();
    }

    @Override
    public void insert(Suscripciones suscripciones) {
        repository.save(suscripciones);
    }

    @Override
    public Suscripciones buscar(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Suscripciones suscripciones) {
        repository.save(suscripciones);
    }
    @Override
    public List<String[]> quantitytypebySuscripciones() {
        return repository.quantitytypebySuscripciones();
    }

    @Override
    public List<String[]> quantityDevicebySuscripciones() {
        return repository.quantityDevicebySuscripciones();
    }
}
