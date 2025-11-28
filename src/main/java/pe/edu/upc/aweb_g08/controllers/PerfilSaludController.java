package pe.edu.upc.aweb_g08.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aweb_g08.dtos.PerfilSaludDTO;
import pe.edu.upc.aweb_g08.entities.PerfilSalud;
import pe.edu.upc.aweb_g08.entities.Usuario;
import pe.edu.upc.aweb_g08.serviceinterfaces.IPerfilSaludService;
import pe.edu.upc.aweb_g08.serviceinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/perfiles-salud")
public class PerfilSaludController {

    @Autowired
    private IPerfilSaludService perfilSaludService;

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping
    public List<PerfilSaludDTO> listar() {
        return perfilSaludService.list().stream().map(perfil -> {
            ModelMapper m = new ModelMapper();
            PerfilSaludDTO dto = m.map(perfil, PerfilSaludDTO.class);
            dto.setIdUsuario(perfil.getUsuario().getIdUsuario());
            dto.setNombreUsuario(perfil.getUsuario().getNombre());
            return dto;
        }).collect(Collectors.toList());
    }


    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody PerfilSaludDTO dto) {
        ModelMapper m = new ModelMapper();
        PerfilSalud perfil = m.map(dto, PerfilSalud.class);

        Usuario usuario = usuarioService.listId(dto.getIdUsuario());
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El usuario con ID " + dto.getIdUsuario() + " no existe.");
        }
        perfil.setUsuario(usuario);

        perfilSaludService.insert(perfil);
        return ResponseEntity.ok("Perfil de salud registrado correctamente.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        PerfilSalud perfil = perfilSaludService.listId(id);
        if (perfil == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un perfil de salud con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        PerfilSaludDTO dto = m.map(perfil, PerfilSaludDTO.class);
        dto.setIdUsuario(perfil.getUsuario().getIdUsuario());
        dto.setNombreUsuario(perfil.getUsuario().getNombre());
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        PerfilSalud perfil = perfilSaludService.listId(id);
        if (perfil == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un perfil de salud con el ID: " + id);
        }
        perfilSaludService.delete(id);
        return ResponseEntity.ok("Perfil de salud con ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody PerfilSaludDTO dto) {
        ModelMapper m = new ModelMapper();
        PerfilSalud perfil = m.map(dto, PerfilSalud.class);

        PerfilSalud existente = perfilSaludService.listId(dto.getIdPerfilSalud());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un perfil de salud con el ID: " + dto.getIdPerfilSalud());
        }

        Usuario usuario = usuarioService.listId(dto.getIdUsuario());
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El usuario con ID " + dto.getIdUsuario() + " no existe.");
        }
        perfil.setUsuario(usuario);

        perfilSaludService.update(perfil);
        return ResponseEntity.ok("Perfil de salud con ID " + dto.getIdPerfilSalud() + " modificado correctamente.");
    }

    @GetMapping("/perfiles-criticos")
    public List<PerfilSaludDTO> listarUsuariosConPerfilAlterado() {
        return perfilSaludService.listarUsuariosConPerfilAlterado();
    }
    @GetMapping("/ultimo/{idUsuario}")
    public ResponseEntity<?> obtenerUltimoPerfil(@PathVariable("idUsuario") int idUsuario) {
        PerfilSalud perfil = perfilSaludService.obtenerUltimoPerfilPorUsuario(idUsuario);
        if (perfil == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró perfil de salud para el usuario con ID: " + idUsuario);
        }
        ModelMapper m = new ModelMapper();
        PerfilSaludDTO dto = m.map(perfil, PerfilSaludDTO.class);
        return ResponseEntity.ok(dto);
    }


}
