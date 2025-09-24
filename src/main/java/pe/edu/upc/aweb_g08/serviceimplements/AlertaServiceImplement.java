package pe.edu.upc.aweb_g08.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aweb_g08.entities.Alertas;
import pe.edu.upc.aweb_g08.repositories.IAlertaRepository;
import pe.edu.upc.aweb_g08.serviceinterfaces.IAlertaService;

import java.util.List;

@Service
public class AlertaServiceImplement implements IAlertaService {

    @Autowired
    private IAlertaRepository aR;

    @Override
    public List<Alertas> list() {
        return aR.findAll();
    }

    @Override
    public void insert(Alertas alerta) {
        aR.save(alerta);
    }

    @Override
    public Alertas listId(int id) {
        return aR.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        aR.deleteById(id);
    }

    @Override
    public void update(Alertas alerta) {
        aR.save(alerta);
    }
}
