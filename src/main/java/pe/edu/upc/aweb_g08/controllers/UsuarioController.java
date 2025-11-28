package pe.edu.upc.aweb_g08.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aweb_g08.dtos.AdminComentarioDTO;
import pe.edu.upc.aweb_g08.dtos.UsuarioDTO;
import pe.edu.upc.aweb_g08.entities.Rol;
import pe.edu.upc.aweb_g08.entities.Usuario;
import pe.edu.upc.aweb_g08.repositories.IRolRepository;
import pe.edu.upc.aweb_g08.repositories.IUsuarioRepository;
import pe.edu.upc.aweb_g08.serviceinterfaces.IUsuarioService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private IUsuarioService usuarioService;
    @Autowired
    private IRolRepository rolRepository;
    // LISTAR TODOS
    @GetMapping
    public List<UsuarioDTO> listar() {
        return usuarioService.list().stream().map(usuario -> {
            ModelMapper m = new ModelMapper();
            return m.map(usuario, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public Usuario insertar(@RequestBody UsuarioDTO dto) {

        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setApellido(dto.getApellido());
        usuario.setEmail(dto.getEmail());
        usuario.setContrasenia(dto.getContrasenia());
        usuario.setFechaNacimiento(dto.getFechaNacimiento());
        usuario.setFechaCreacion(LocalDate.now());
        usuario.setFechaSuscripcion(dto.getFechaSuscripcion());
        Rol rol = rolRepository.findById(dto.getIdRol())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado con id: " + dto.getIdRol()));
        usuario.getRoles().add(rol);

        return usuarioRepository.save(usuario);
    }


    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        Usuario usuario = usuarioService.listId(id);
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        UsuarioDTO dto = m.map(usuario, UsuarioDTO.class);
        return ResponseEntity.ok(dto);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Usuario usuario = usuarioService.listId(id);
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario con el ID: " + id);
        }
        usuarioService.delete(id);
        return ResponseEntity.ok("Usuario con ID " + id + " eliminado correctamente.");
    }

    // MODIFICAR
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario usuario = m.map(dto, Usuario.class);

        Usuario existente = usuarioService.listId(usuario.getIdUsuario());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un usuario con el ID: " + usuario.getIdUsuario());
        }
        usuarioService.update(usuario);
        return ResponseEntity.ok("Usuario con ID " + usuario.getIdUsuario() + " modificado correctamente.");
    }









}
