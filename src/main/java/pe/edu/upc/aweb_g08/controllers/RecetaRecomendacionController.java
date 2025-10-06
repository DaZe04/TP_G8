package pe.edu.upc.aweb_g08.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aweb_g08.dtos.RecetaRecomendacionDTO;
import pe.edu.upc.aweb_g08.entities.Receta_Recomendacion;
import pe.edu.upc.aweb_g08.serviceinterfaces.IRecetaRecomendacionService;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/receta-recomendacion")
public class RecetaRecomendacionController {

    @Autowired
    private IRecetaRecomendacionService recetaService;


    @GetMapping
    public List<RecetaRecomendacionDTO> listar() {
        return recetaService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RecetaRecomendacionDTO.class);
        }).collect(Collectors.toList());
    }


    @PostMapping
    public void insertar(@RequestBody RecetaRecomendacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Receta_Recomendacion recetas = m.map(dto, Receta_Recomendacion.class);
        recetaService.insert(recetas);
    }


    @GetMapping("/perfil/{idPerfil}")
    public List<RecetaRecomendacionDTO> listarPorPerfil(@PathVariable("idPerfil") int idPerfil) {
        return recetaService.listarPorPerfil(idPerfil).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RecetaRecomendacionDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Receta_Recomendacion r = recetaService.listId(id);
        if (r == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        recetaService.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @GetMapping("/cantidad-minima/{minCantidad}")
    public List<RecetaRecomendacionDTO> listarPorCantidadMinima(@PathVariable("minCantidad") float minCantidad) {
        return recetaService.listarPorCantidadMinima(minCantidad).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RecetaRecomendacionDTO.class);
        }).collect(Collectors.toList());
    }

}
