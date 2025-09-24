package pe.edu.upc.aweb_g08.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aweb_g08.dtos.UsuarioDTO;
import pe.edu.upc.aweb_g08.entities.Rol;
import pe.edu.upc.aweb_g08.entities.Usuario;
import pe.edu.upc.aweb_g08.serviceinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;

    // LISTAR TODOS
    @GetMapping
    public List<UsuarioDTO> listar() {
        return usuarioService.list().stream().map(usuario -> {
            ModelMapper m = new ModelMapper();
            return m.map(usuario, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    // INSERTAR
    @PostMapping("/insertar")
    public void insertar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario usuario = m.map(dto, Usuario.class);

        // Asignar rol manualmente
        Rol rol = new Rol();
        rol.setIdRol(dto.getIdRol());
        usuario.setRol(rol);

        usuarioService.insert(usuario);
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


    @GetMapping("/buscar")
    public ResponseEntity<?> buscar(@RequestParam String nombre) {
        List<Usuario> usuarios = usuarioService.buscarService(nombre);

        if (usuarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron usuarios con el nombre: " + nombre);
        }

        List<UsuarioDTO> listaDTO = usuarios.stream().map(usuario -> {
            ModelMapper m = new ModelMapper();
            return m.map(usuario, UsuarioDTO.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }

}
