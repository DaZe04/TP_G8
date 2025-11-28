package pe.edu.upc.aweb_g08.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aweb_g08.dtos.DispositivosDTO;
import pe.edu.upc.aweb_g08.entities.Dispositivos;
import pe.edu.upc.aweb_g08.entities.Usuario;
import pe.edu.upc.aweb_g08.serviceinterfaces.IDispositivosService;
import pe.edu.upc.aweb_g08.serviceinterfaces.IUsuarioService;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Dispo")
public class DispositivosController {
    @Autowired
    private IDispositivosService service;

    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody DispositivosDTO sdto) {
        try {
            System.out.println("DTO recibido: " + sdto.getIdUsuario()); // AGREGAR ESTO
            System.out.println("Tipo: " + sdto.getTipo()); // Y ESTO

            // 1. Buscar el usuario existente
            Usuario usuario = usuarioService.listId(sdto.getIdUsuario());
            if (usuario == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("El usuario con ID " + sdto.getIdUsuario() + " no existe");
            }

            // 2. Crear el objeto Dispositivo SIN mapear
            Dispositivos dispositivo = new Dispositivos();
            dispositivo.setTipo(sdto.getTipo());
            dispositivo.setMarca(sdto.getMarca());
            dispositivo.setModelo(sdto.getModelo());
            dispositivo.setFechaSincronizacion(java.time.LocalDate.now());
            dispositivo.setUsuario(usuario);

            // 3. Guardar
            service.insert(dispositivo);
            return ResponseEntity.ok("Dispositivo registrado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/dtos")
    public List<DispositivosDTO> listar() {
        return service.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, DispositivosDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Dispositivos d = service.buscar(id);
        if (d == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody DispositivosDTO dto) {
        try {
            // 1. Validar que el dispositivo exista
            Dispositivos existente = service.buscar(dto.getIdDispositivo());
            if (existente == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No se puede modificar. No existe un registro con el ID: " + dto.getIdDispositivo());
            }

            // 2. Validar que el usuario exista
            Usuario usuario = usuarioService.listId(dto.getIdUsuario());
            if (usuario == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("El usuario con ID " + dto.getIdUsuario() + " no existe");
            }

            // 3. Actualizar el dispositivo SIN mapear
            existente.setTipo(dto.getTipo());
            existente.setMarca(dto.getMarca());
            existente.setModelo(dto.getModelo());
            existente.setFechaSincronizacion(dto.getFechaSincronizacion());
            existente.setUsuario(usuario);

            service.update(existente);
            return ResponseEntity.ok("Registro con ID " + dto.getIdDispositivo() + " modificado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }
}