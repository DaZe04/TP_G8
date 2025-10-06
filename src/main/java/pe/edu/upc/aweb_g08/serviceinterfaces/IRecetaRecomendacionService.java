package pe.edu.upc.aweb_g08.serviceinterfaces;

import pe.edu.upc.aweb_g08.entities.Receta_Recomendacion;
import pe.edu.upc.aweb_g08.entities.Recetas;

import java.util.List;

public interface IRecetaRecomendacionService {
    List<Receta_Recomendacion> list();
    void insert(Receta_Recomendacion recetas);
    List<Receta_Recomendacion> buscarPorIngrediente(String ingrediente);
    Receta_Recomendacion listId(int id);
    void delete(int id);

    List<Receta_Recomendacion> listarPorCantidadMinima(float minCantidad);
    List<Receta_Recomendacion> listarPorPerfil(int idPerfil);
}

