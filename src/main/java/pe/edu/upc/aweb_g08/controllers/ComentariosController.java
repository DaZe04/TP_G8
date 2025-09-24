package pe.edu.upc.aweb_g08.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aweb_g08.dtos.ComentariosDTO;
import pe.edu.upc.aweb_g08.serviceinterfaces.IComentariosService;
import pe.edu.upc.aweb_g08.entities.Comentarios;
import pe.edu.upc.aweb_g08.dtos.ComentariosDTO;



import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/comentarios")
public class ComentariosController {
    @Autowired
    private IComentariosService comentarioService;

    // LISTAR
    @GetMapping
    public List<ComentariosDTO> listar() {
        return comentarioService.list().stream().map(comentarios -> {
            ModelMapper m = new ModelMapper();
            return m.map(comentarios, ComentariosDTO.class);
        }).collect(Collectors.toList());
    }

    // INSERTAR
    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody ComentariosDTO dto) {
        ModelMapper m = new ModelMapper();
        Comentarios comentarios = m.map(dto, Comentarios.class);

        Usuario usuario = new Usuario();
        usuario.setIdUsuario(dto.getIdUsuario());
        comentarios.setUsuario(usuario);

        comentarioService.insert(comentarios);
        return ResponseEntity.status(HttpStatus.CREATED).body("Comentario creado correctamente");
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        Comentarios comentarios = comentarioService.listId(id);
        if (comentarios == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un comentario con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        ComentariosDTO dto = m.map(comentarios, ComentariosDTO.class);
        return ResponseEntity.ok(dto);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Comentarios comentarios = comentarioService.listId(id);
        if (comentarios == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un comentario con ID: " + id);
        }
        comentarioService.delete(id);
        return ResponseEntity.ok("Comentario con ID " + id + " eliminado correctamente.");
    }

    // MODIFICAR
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody ComentariosDTO dto) {
        ModelMapper m = new ModelMapper();
        Comentarios comentarios = m.map(dto, Comentarios.class);

        Comentarios existente = comentarioService.listId(comentarios.getIdComentarios());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un comentario con ID: " + comentarios.getIdComentarios());
        }

        Usuario usuario = new Usuario();
        usuario.setIdUsuario(dto.getIdUsuario());
        comentarios.setUsuario(usuario);

        comentarioService.update(comentarios);
        return ResponseEntity.ok("Comentario con ID " + comentarios.getIdComentarios() + " modificado correctamente.");
    }
}
