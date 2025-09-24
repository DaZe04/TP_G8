package pe.edu.upc.aweb_g08.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aweb_g08.entities.Reportes;
import pe.edu.upc.aweb_g08.repositories.IReporteRepository;
import pe.edu.upc.aweb_g08.serviceinterfaces.IReporteService;

import java.util.List;

@Service
public class ReporteServiceImplement implements IReporteService {

    @Autowired
    private IReporteRepository rR;

    @Override
    public List<Reportes> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Reportes reporte) {
        rR.save(reporte);
    }

    @Override
    public Reportes listId(int id) {
        return rR.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public void update(Reportes reporte) {
        rR.save(reporte);
    }
}
