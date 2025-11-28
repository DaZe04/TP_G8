package pe.edu.upc.aweb_g08.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aweb_g08.dtos.IngredienteCaloriasDTO;
import pe.edu.upc.aweb_g08.dtos.IngredientesDTO;
import pe.edu.upc.aweb_g08.entities.Ingredientes;
import pe.edu.upc.aweb_g08.serviceinterfaces.IingredientesService;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;
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
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        Ingredientes ing = ingredienteService.listId(id);
        if (ing == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un ingrediente con ID: " + id);
        try {
            ingredienteService.delete(id);
            return ResponseEntity.ok("Ingrediente eliminado correctamente.");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No se puede eliminar porque está relacionado con otros datos.");
        }
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
    @GetMapping("/ingredientes/topcalorias")
    public List<IngredienteCaloriasDTO> topIngredientesCaloricos() {
        List<String[]> filas = ingredienteService.topIngredientesCaloricos();
        List<IngredienteCaloriasDTO> resultado = new ArrayList<>();

        for (String[] fila : filas) {
            // fila[0] = nombre, fila[1] = calorias (como string)
            IngredienteCaloriasDTO dto = new IngredienteCaloriasDTO();
            dto.setNombre(fila[0]);
            dto.setTotalCalorias(Float.parseFloat(fila[1]));
            resultado.add(dto);
        }

        return resultado;
    }

}
