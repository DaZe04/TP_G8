package pe.edu.upc.aweb_g08.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aweb_g08.entities.RegistroComida;
import pe.edu.upc.aweb_g08.repositories.IRegistroComidaRepository;
import pe.edu.upc.aweb_g08.serviceinterfaces.IRegistroComidaService;

import java.util.List;
@Service
public class IRegistroComidaImplements implements IRegistroComidaService {


    @Autowired
    private IRegistroComidaRepository rcRepo;

    @Override
    public void insert(RegistroComida registro) { rcRepo.save(registro); }

    @Override
    public List<RegistroComida> list() { return rcRepo.findAll(); }

    @Override
    public void delete(int id) { rcRepo.deleteById(id); }

    @Override
    public void update(RegistroComida registroComida) { rcRepo.save(registroComida);}

    @Override
    public RegistroComida listId(int id) { return rcRepo.findById(id).orElse(null); }
}
