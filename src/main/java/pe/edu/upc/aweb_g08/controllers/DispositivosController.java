package pe.edu.upc.aweb_g08.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aweb_g08.dtos.DispositivosDTO;
import pe.edu.upc.aweb_g08.entities.Dispositivos;
import pe.edu.upc.aweb_g08.servicesinterfaces.IDispositivosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Dispo")
public class DispositivosController {
    @Autowired
    private IDispositivosService service;
    @PostMapping
    public void insertar(@RequestBody DispositivosDTO sdto)
    {
        ModelMapper m = new ModelMapper();
        Dispositivos s=m.map(sdto,Dispositivos.class);
        service.insert(s);
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
        ModelMapper m = new ModelMapper();
        Dispositivos dis = m.map(dto, Dispositivos.class);

        Dispositivos existente = service.buscar(dis.getIdDispositivo());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + dis.getIdDispositivo());
        }
        service.update(dis);
        return ResponseEntity.ok("Registro con ID " + dis.getIdDispositivo() + " modificado correctamente.");
    }
}
