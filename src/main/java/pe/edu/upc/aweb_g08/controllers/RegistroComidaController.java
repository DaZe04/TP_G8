package pe.edu.upc.aweb_g08.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aweb_g08.dtos.RegistroComidaDTO;
import pe.edu.upc.aweb_g08.entities.RegistroComida;
import pe.edu.upc.aweb_g08.serviceinterfaces.IRegistroComidaService;

import java.time.LocalDate;
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
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody RegistroComida registroComida) {
        RegistroComida existente = rcService.listId(registroComida.getIdRegistro());

        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + registroComida.getIdRegistro());
        }

        rcService.update(registroComida);

        return ResponseEntity.ok("Registro con ID " + registroComida.getIdRegistro() + " modificado correctamente.");
    }

    @GetMapping("/por-receta/{idReceta}")
    public ResponseEntity<List<RegistroComidaDTO>> listarPorReceta(@PathVariable("idReceta") int idReceta) {
        List<RegistroComidaDTO> lista = rcService.listarPorReceta(idReceta)
                .stream()
                .map(x -> new ModelMapper().map(x, RegistroComidaDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/por-fechas")
    public ResponseEntity<List<RegistroComidaDTO>> listarPorRangoDeFechas(
            @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam("fin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fin) {

        List<RegistroComidaDTO> lista = rcService.listarPorRangoDeFechas(inicio, fin)
                .stream()
                .map(x -> new ModelMapper().map(x, RegistroComidaDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }
}
