package pe.edu.upc.aweb_g08.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aweb_g08.dtos.QuantityDeviceSusDTO;
import pe.edu.upc.aweb_g08.dtos.QuantityTypeSusDTO;
import pe.edu.upc.aweb_g08.dtos.SuscripcionesDTO;
import pe.edu.upc.aweb_g08.entities.Suscripciones;
import pe.edu.upc.aweb_g08.entities.Usuario;
import pe.edu.upc.aweb_g08.repositories.IUsuarioRepository;
import pe.edu.upc.aweb_g08.serviceinterfaces.ISuscripcionesService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Suscri")
public class SuscripcionesController {
    @Autowired
    private ISuscripcionesService service;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody SuscripcionesDTO sdto) {
        ModelMapper m = new ModelMapper();
        Suscripciones s = m.map(sdto, Suscripciones.class);
        Usuario usuario = usuarioRepository.findById(sdto.getId_usuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + sdto.getId_usuario()));
        s.setId_usuario(usuario);
        service.insert(s);
        return ResponseEntity.ok("Suscripción creada correctamente");
    }
    @GetMapping("/dtos")
    public List<SuscripcionesDTO> listar() {
        return service.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, SuscripcionesDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Suscripciones s = service.buscar(id);
        if (s == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody SuscripcionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Suscripciones sus = m.map(dto, Suscripciones.class);

        Suscripciones existente = service.buscar(sus.getId_suscripciones());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + sus.getId_suscripciones());
        }
        service.update(sus);
        return ResponseEntity.ok("Registro con ID " + sus.getId_suscripciones() + " modificado correctamente.");
    }
    @GetMapping("/consulta1")
    public ResponseEntity<?> ObtenerCantidadTipoSuscripciones() {
        List<QuantityTypeSusDTO> listDTO = new ArrayList<>();
        List<String[]> fila = service.quantitytypebySuscripciones();
        if(fila.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe suscripciones activas");
        }
        for (String[] s : fila) {
            QuantityTypeSusDTO dto = new QuantityTypeSusDTO();
            dto.setTipo(s[0]);
            dto.setCantidad(Integer.parseInt(s[1]));
            listDTO.add(dto);
        }
        return ResponseEntity.ok(listDTO);
    }
    @GetMapping("/consulta2")
    public ResponseEntity<?> ObtenerCantidadDispositivoSuscripciones() {
        List<QuantityDeviceSusDTO> listDTO = new ArrayList<>();
        List<String[]> fila = service.quantityDevicebySuscripciones();
        if(fila.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe dispositivos en suscripciones activas");
        }
        for (String[] s : fila) {
            QuantityDeviceSusDTO dto = new QuantityDeviceSusDTO();
            dto.setTipo_suscripcion(s[0]);
            dto.setCantidad_dispositivos(Integer.parseInt(s[1]));
            listDTO.add(dto);
        }
        return ResponseEntity.ok(listDTO);
    }
}
