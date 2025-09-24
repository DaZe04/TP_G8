package pe.edu.upc.aweb_g08.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aweb_g08.entities.Comentarios;
import pe.edu.upc.aweb_g08.repositories.IComentarioRepository;
import pe.edu.upc.aweb_g08.serviceinterfaces.IComentariosService;

import java.util.List;
@Service

public class ComentariosServiceImplement implements IComentariosService {
    @Autowired
    private IComentarioRepository cR;

    @Override
    public List<Comentarios> list() {
        return cR.findAll();
    }

    @Override
    public void insert(Comentarios comentarios) {
        cR.save(comentarios);
    }

    @Override
    public Comentarios listId(int id) {
        return cR.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    @Override
    public void update(Comentarios comentarios) {
        cR.save(comentarios);
    }

}
