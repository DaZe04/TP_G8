package pe.edu.upc.aweb_g08.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aweb_g08.entities.PerfilSalud;
import pe.edu.upc.aweb_g08.repositories.IPerfilSaludRepository;
import pe.edu.upc.aweb_g08.serviceinterfaces.IPerfilSaludService;
import pe.edu.upc.aweb_g08.dtos.PerfilSaludDTO;


import java.util.List;

@Service
public class PerfilSaludServiceImplement implements IPerfilSaludService {

    private final IPerfilSaludRepository perfilSaludRepository;
    public PerfilSaludServiceImplement(IPerfilSaludRepository perfilSaludRepository) {
        this.perfilSaludRepository = perfilSaludRepository;
    }

    @Autowired
    private IPerfilSaludRepository psR;

    @Override
    public List<PerfilSalud> list() {
        return psR.findAll();
    }

    @Override
    public void insert(PerfilSalud perfilSalud) {
        psR.save(perfilSalud);
    }

    @Override
    public PerfilSalud listId(int id) {
        return psR.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        psR.deleteById(id);
    }

    @Override
    public void update(PerfilSalud perfilSalud) {
        psR.save(perfilSalud);
    }

    @Override
    public List<PerfilSaludDTO> listarUsuariosConPerfilAlterado() {
        return perfilSaludRepository.listarUsuariosConPerfilAlterado();
    }
}
