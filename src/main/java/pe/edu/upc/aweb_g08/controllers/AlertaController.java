package pe.edu.upc.aweb_g08.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aweb_g08.dtos.AlertaDTO;
import pe.edu.upc.aweb_g08.entities.Alertas;
import pe.edu.upc.aweb_g08.entities.Usuario;
import pe.edu.upc.aweb_g08.serviceinterfaces.IAlertaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alertas")
public class AlertaController {

    @Autowired
    private IAlertaService alertaService;

    // LISTAR
    @GetMapping
    public List<AlertaDTO> listar() {
        return alertaService.list().stream().map(alerta -> {
            ModelMapper m = new ModelMapper();
            return m.map(alerta, AlertaDTO.class);
        }).collect(Collectors.toList());
    }

    // INSERTAR
    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody AlertaDTO dto) {
        ModelMapper m = new ModelMapper();
        Alertas alerta = m.map(dto, Alertas.class);

        Usuario usuario = new Usuario();
        usuario.setIdUsuario(dto.getIdUsuario());
        alerta.setUsuario(usuario);

        alertaService.insert(alerta);
        return ResponseEntity.status(HttpStatus.CREATED).body("Alerta creada correctamente");
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        Alertas alerta = alertaService.listId(id);
        if (alerta == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una alerta con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        AlertaDTO dto = m.map(alerta, AlertaDTO.class);
        return ResponseEntity.ok(dto);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Alertas alerta = alertaService.listId(id);
        if (alerta == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una alerta con ID: " + id);
        }
        alertaService.delete(id);
        return ResponseEntity.ok("Alerta con ID " + id + " eliminada correctamente.");
    }

    // MODIFICAR
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody AlertaDTO dto) {
        ModelMapper m = new ModelMapper();
        Alertas alerta = m.map(dto, Alertas.class);

        Alertas existente = alertaService.listId(alerta.getIdAlerta());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe una alerta con ID: " + alerta.getIdAlerta());
        }

        Usuario usuario = new Usuario();
        usuario.setIdUsuario(dto.getIdUsuario());
        alerta.setUsuario(usuario);

        alertaService.update(alerta);
        return ResponseEntity.ok("Alerta con ID " + alerta.getIdAlerta() + " modificada correctamente.");
    }
}
