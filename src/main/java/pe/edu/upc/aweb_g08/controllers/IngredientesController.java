package pe.edu.upc.aweb_g08.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aweb_g08.dtos.IngredientesDTO;
import pe.edu.upc.aweb_g08.entities.Ingredientes;
import pe.edu.upc.aweb_g08.serviceinterfaces.IingredientesService;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/ingredientes")
public class IngredientesController {
    @Autowired
    private IingredientesService ingredienteService;

    // LISTAR
    @GetMapping
    public List<IngredientesDTO> listar() {
        return ingredienteService.list().stream().map(ingredientes -> {
            ModelMapper m = new ModelMapper();
            return m.map(ingredientes, IngredientesDTO.class);
        }).collect(Collectors.toList());
    }

    // INSERTAR
    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody IngredientesDTO dto) {
        ModelMapper m = new ModelMapper();
        Ingredientes ingredientes = m.map(dto, Ingredientes.class);

        ingredienteService.insert(ingredientes);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ingrediente creado correctamente");
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        Ingredientes ingredientes = ingredienteService.listId(id);
        if (ingredientes == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un ingrediente con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        IngredientesDTO dto = m.map(ingredientes, IngredientesDTO.class);
        return ResponseEntity.ok(dto);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Ingredientes ingredientes = ingredienteService.listId(id);
        if (ingredientes == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un ingrediente con ID: " + id);
        }
        ingredienteService.delete(id);
        return ResponseEntity.ok("Ingrediente con ID " + id + " eliminado correctamente.");
    }

    // MODIFICAR
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody IngredientesDTO dto) {
        ModelMapper m = new ModelMapper();
        Ingredientes ingredientes = m.map(dto, Ingredientes.class);

        Ingredientes existente = ingredienteService.listId(ingredientes.getIdIngredientes());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un ingrediente con ID: " + ingredientes.getIdIngredientes());
        }

        ingredienteService.update(ingredientes);
        return ResponseEntity.ok("Ingrediente con ID " + ingredientes.getIdIngredientes() + " modificado correctamente.");
    }


}
