package pe.edu.upc.aweb_g08.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aweb_g08.entities.Receta_Recomendacion;
import pe.edu.upc.aweb_g08.repositories.IRecetaRecomendacionRepository;
import pe.edu.upc.aweb_g08.serviceinterfaces.IRecetaRecomendacionService;
import java.util.List;

@Service
public class IRecetaRecomendacionImplement implements IRecetaRecomendacionService {

    @Autowired
    private IRecetaRecomendacionRepository recetaRecomendacionRepo;

    @Autowired
    private IRecetaRepository recetaRepo;

    @Autowired
    private IUsuarioRepository usuarioRepo;

    @Override
    public void insert(RecetaRecomendacionDTO dto) {
        Receta_Recomendacion entity = new Receta_Recomendacion();
        entity.setCantidad(dto.getCantidad());
        entity.setUnidad(dto.getUnidad());

        // 🔗 Buscar la receta por ID
        Recetas receta = recetaRepo.findById(dto.getIdReceta())
                .orElseThrow(() -> new RuntimeException("Receta no encontrada"));
        entity.setReceta(receta);

        // 🔗 Buscar el usuario por ID
        Usuario usuario = usuarioRepo.findById(dto.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        entity.setUsuario(usuario);

        recetaRecomendacionRepo.save(entity);
    }
}
