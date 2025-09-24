package pe.edu.upc.aweb_g08.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aweb_g08.dtos.ForoDTO;
import pe.edu.upc.aweb_g08.entities.Foro;
import pe.edu.upc.aweb_g08.entities.Usuario;
import pe.edu.upc.aweb_g08.serviceinterfaces.IForoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/foros")
public class ForoController {
    @Autowired
    private IForoService foroService;

    // LISTAR
    @GetMapping
    public List<ForoDTO> listar() {
        return foroService.list().stream().map(foro -> {
            ModelMapper m = new ModelMapper();
            return m.map(foro, ForoDTO.class);
        }).collect(Collectors.toList());
    }

    // INSERTAR
    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody ForoDTO dto) {
        ModelMapper m = new ModelMapper();
        Foro foro = m.map(dto, Foro.class);

        Usuario usuario = new Usuario();
        usuario.setIdUsuario(dto.getIdUsuario());
        foro.setUsuario(usuario);

        foroService.insert(foro);
        return ResponseEntity.status(HttpStatus.CREATED).body("Foro creado correctamente");
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        Foro foro = foroService.listId(id);
        if (foro == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un foro con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        ForoDTO dto = m.map(foro, ForoDTO.class);
        return ResponseEntity.ok(dto);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Foro foro = foroService.listId(id);
        if (foro == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un foro con ID: " + id);
        }
        foroService.delete(id);
        return ResponseEntity.ok("Foro con ID " + id + " eliminado correctamente.");
    }

    // MODIFICAR
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody ForoDTO dto) {
        ModelMapper m = new ModelMapper();
        Foro foro = m.map(dto, Foro.class);

        Foro existente = foroService.listId(foro.getIdForo());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un foro con ID: " + foro.getIdForo());
        }

        Usuario usuario = new Usuario();
        usuario.setIdUsuario(dto.getIdUsuario());
        foro.setUsuario(usuario);

        foroService.update(foro);
        return ResponseEntity.ok("Foro con ID " + foro.getIdForo() + " modificado correctamente.");
    }
}
