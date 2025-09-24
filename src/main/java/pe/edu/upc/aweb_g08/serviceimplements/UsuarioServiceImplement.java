package pe.edu.upc.aweb_g08.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aweb_g08.entities.Usuario;
import pe.edu.upc.aweb_g08.repositories.IUsuarioRepository;
import pe.edu.upc.aweb_g08.serviceinterfaces.IUsuarioService;


import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {

    @Autowired
    private IUsuarioRepository uR;

    @Override
    public List<Usuario> list() {
        return uR.findAll();
    }

    @Override
    public void insert(Usuario usuario) {
        uR.save(usuario);
    }

    @Override
    public Usuario listId(int id) {
        return uR.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        uR.deleteById(id);
    }

    @Override
    public void update(Usuario usuario) {
        uR.save(usuario);
    }

    @Override
    public List<Usuario> buscarService(String nombre) {
        return uR.buscarService(nombre);
    }


}
