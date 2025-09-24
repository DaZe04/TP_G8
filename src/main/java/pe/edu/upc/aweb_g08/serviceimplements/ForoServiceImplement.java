package pe.edu.upc.aweb_g08.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aweb_g08.entities.Comentarios;
import pe.edu.upc.aweb_g08.entities.Foro;
import pe.edu.upc.aweb_g08.repositories.IComentarioRepository;
import pe.edu.upc.aweb_g08.repositories.IForoRepository;
import pe.edu.upc.aweb_g08.serviceinterfaces.IForoService;
import pe.edu.upc.aweb_g08.serviceinterfaces.IingredientesService;

import java.util.List;

@Service
public class ForoServiceImplement implements IForoService {
    @Autowired
    private IForoRepository fR;

    @Override
    public List<Foro> list() {
        return fR.findAll();
    }

    @Override
    public void insert(Foro foro) {
        fR.save(foro);
    }

    @Override
    public Foro listId(int id) {
        return fR.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        fR.deleteById(id);
    }

    @Override
    public void update(Foro foro) {
        fR.save(foro);
    }
}
