package pe.edu.upc.aweb_g08.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aweb_g08.dtos.RecetasDTO;
import pe.edu.upc.aweb_g08.entities.Recetas;
import pe.edu.upc.aweb_g08.serviceinterfaces.IRecetasService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Recetas")
public class RecetaController {
    @Autowired
    private IRecetasService  service;
    @PostMapping
    public void insertar(@RequestBody RecetasDTO  sdto)
    {
        ModelMapper m = new ModelMapper();
        Recetas receta=m.map(sdto,Recetas.class);
        service.insert(receta);
    }
    @GetMapping("/dtos")
    public List<RecetasDTO> listar() {
        return service.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, RecetasDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Recetas  r = service.buscar(id);
        if (r == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody RecetasDTO  dto) {
        ModelMapper m = new ModelMapper();
        Recetas  receta  = m.map(dto, Recetas .class);

        Recetas  existente = service.buscar(receta.getIdRecetas());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + receta.getIdRecetas());
        }
        service.update(receta);
        return ResponseEntity.ok("Registro con ID " + receta.getIdRecetas() + " modificado correctamente.");
    }
}
