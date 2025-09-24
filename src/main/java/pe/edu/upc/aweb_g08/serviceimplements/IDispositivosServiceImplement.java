package pe.edu.upc.aweb_g08.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aweb_g08.entities.Dispositivos;
import pe.edu.upc.aweb_g08.repositories.IDispositivosRepository;
import pe.edu.upc.aweb_g08.serviceinterfaces.IDispositivosService;

import java.util.List;
@Service
public class IDispositivosServiceImplement implements IDispositivosService {

    @Autowired
    private IDispositivosRepository repository;


    @Override
    public List<Dispositivos> list() {
        return repository.findAll();
    }

    @Override
    public void insert(Dispositivos dispositivo) {
        repository.save(dispositivo);
    }

    @Override
    public Dispositivos buscar(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Dispositivos dispositivo) {
        repository.save(dispositivo);
    }
}
