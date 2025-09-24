package pe.edu.upc.aweb_g08.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aweb_g08.dtos.RegistroComidaDTO;
import pe.edu.upc.aweb_g08.entities.RegistroComida;
import pe.edu.upc.aweb_g08.serviceinterfaces.IRegistroComidaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/registro-comida")
public class RegistroComidaController {
    @Autowired
    private IRegistroComidaService rcService;

    @GetMapping
    public List<RegistroComidaDTO> listar() {
        return rcService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RegistroComidaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody RegistroComidaDTO dto) {
        ModelMapper m = new ModelMapper();
        RegistroComida registro = m.map(dto, RegistroComida.class);
        rcService.insert(registro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable("id") Integer id) {
        RegistroComida r = rcService.listId(id);
        if (r == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        RegistroComidaDTO dto = m.map(r, RegistroComidaDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        RegistroComida r = rcService.listId(id);
        if (r == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        rcService.delete(id);
        return ResponseEntity.ok("Registro eliminado correctamente con ID: " + id);
    }
}
