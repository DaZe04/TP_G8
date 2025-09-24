package pe.edu.upc.aweb_g08.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aweb_g08.dtos.Lista_ComprasDTO;
import pe.edu.upc.aweb_g08.entities.Lista_Compras;
import pe.edu.upc.aweb_g08.serviceinterfaces.ILista_ComprasService;
import pe.edu.upc.aweb_g08.entities.Ingredientes;


import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/listaCompras")
public class Lista_ComprasController  {
    @Autowired
    private ILista_ComprasService lcService;
    @PostMapping
    public void insertar(@RequestBody Lista_ComprasDTO dto) {
        ModelMapper m = new ModelMapper();
        Lista_Compras lc = m.map(dto, Lista_Compras.class);

        Ingredientes ing = new Ingredientes();
        ing.setIdIngredientes(dto.getIdIngrediente());
        lc.setIngrediente(ing);

        lcService.insert(lc);
    }
    @GetMapping("/dtos")
    public List<Lista_ComprasDTO> listar() {
        return lcService.list().stream().map(entity -> {
            ModelMapper m = new ModelMapper();
            Lista_ComprasDTO dto = m.map(entity, Lista_ComprasDTO.class);
            dto.setIdIngrediente(entity.getIngrediente().getIdIngredientes());
            return dto;
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        lcService.delete(id);
    }
    @PutMapping
    public void modificar(@RequestBody Lista_ComprasDTO dto) {
        ModelMapper m = new ModelMapper();
        Lista_Compras lc = m.map(dto, Lista_Compras.class);

        Ingredientes ing = new Ingredientes();
        ing.setIdIngredientes(dto.getIdIngrediente());
        lc.setIngrediente(ing);

        lcService.update(lc);
    }
}
