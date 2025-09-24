package pe.edu.upc.aweb_g08.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aweb_g08.dtos.ReportesDTO;
import pe.edu.upc.aweb_g08.entities.Reportes;
import pe.edu.upc.aweb_g08.entities.Usuario;
import pe.edu.upc.aweb_g08.serviceinterfaces.IReporteService;
import pe.edu.upc.aweb_g08.serviceinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private IReporteService reporteService;

    @Autowired
    private IUsuarioService usuarioService;

    // LISTAR
    @GetMapping
    public List<ReportesDTO> listar() {
        return reporteService.list().stream().map(reporte -> {
            ModelMapper m = new ModelMapper();
            ReportesDTO dto = m.map(reporte, ReportesDTO.class);
            dto.setIdUsuario(reporte.getUsuario().getIdUsuario());
            dto.setNombreUsuario(reporte.getUsuario().getNombre());
            return dto;
        }).collect(Collectors.toList());
    }

    // INSERTAR
    @PostMapping("/insertar")
    public ResponseEntity<String> insertar(@RequestBody ReportesDTO dto) {
        ModelMapper m = new ModelMapper();
        Reportes reporte = m.map(dto, Reportes.class);

        Usuario usuario = usuarioService.listId(dto.getIdUsuario());
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El usuario con ID " + dto.getIdUsuario() + " no existe.");
        }
        reporte.setUsuario(usuario);

        reporteService.insert(reporte);
        return ResponseEntity.ok("Reporte registrado correctamente.");
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        Reportes reporte = reporteService.listId(id);
        if (reporte == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un reporte con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        ReportesDTO dto = m.map(reporte, ReportesDTO.class);
        dto.setIdUsuario(reporte.getUsuario().getIdUsuario());
        dto.setNombreUsuario(reporte.getUsuario().getNombre());
        return ResponseEntity.ok(dto);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Reportes reporte = reporteService.listId(id);
        if (reporte == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un reporte con el ID: " + id);
        }
        reporteService.delete(id);
        return ResponseEntity.ok("Reporte con ID " + id + " eliminado correctamente.");
    }

    // MODIFICAR
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody ReportesDTO dto) {
        ModelMapper m = new ModelMapper();
        Reportes reporte = m.map(dto, Reportes.class);

        Reportes existente = reporteService.listId(dto.getIdReporte());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un reporte con el ID: " + dto.getIdReporte());
        }

        Usuario usuario = usuarioService.listId(dto.getIdUsuario());
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El usuario con ID " + dto.getIdUsuario() + " no existe.");
        }
        reporte.setUsuario(usuario);

        reporteService.update(reporte);
        return ResponseEntity.ok("Reporte con ID " + dto.getIdReporte() + " modificado correctamente.");
    }
}
