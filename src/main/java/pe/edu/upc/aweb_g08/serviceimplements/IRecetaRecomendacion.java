package pe.edu.upc.aweb_g08.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aweb_g08.entities.Receta_Recomendacion;
import pe.edu.upc.aweb_g08.repositories.IRecetaRecomendacionRepository;
import pe.edu.upc.aweb_g08.serviceinterfaces.IRecetaRecomendacionService;

import java.util.List;
@Service

public class IRecetaRecomendacion implements IRecetaRecomendacionService {

    @Autowired
    private IRecetaRecomendacionRepository rrRepository;

    @Override
    public List<Receta_Recomendacion> list() { return rrRepository.findAll(); }

    @Override
    public void insert(Receta_Recomendacion recomendacion) { rrRepository.save(recomendacion); }


    @Override
    public Receta_Recomendacion listId(int id) { return rrRepository.findById(id).orElse(null); }

    @Override
    public void delete(int id) { rrRepository.deleteById(id); }

    @Override
    public void update(Receta_Recomendacion recomendacion) {rrRepository.save(recomendacion);}

    @Override
    public List<Receta_Recomendacion> listarPorPerfil(int idUsuario) { return rrRepository.findByUsuario(idUsuario); }

}
