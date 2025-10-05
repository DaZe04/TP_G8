package pe.edu.upc.aweb_g08.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

        @PutMapping
    public ResponseEntity<String> modificar(@RequestBody Receta_Recomendacion receta) {
        Receta_Recomendacion existente = recetaService.listId(receta.getIdRecomendacion());

        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + receta.getIdRecomendacion());
        }

        recetaService.update(receta);

        return ResponseEntity.ok("Registro con ID " + receta.getReceta() + " modificado correctamente.");
    }

    @GetMapping("/cantidad-minima/{minCantidad}")
    public List<RecetaRecomendacionDTO> listarPorCantidadMinima(@PathVariable("minCantidad") float minCantidad) {
        return recetaService.listarPorCantidadMinima(minCantidad).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RecetaRecomendacionDTO.class);
        }).collect(Collectors.toList());
    }
}
