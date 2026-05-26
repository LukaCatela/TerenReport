package hr.fipu.terenreport.service;

import hr.fipu.terenreport.model.Kampanja;
import hr.fipu.terenreport.repository.KampanjaRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KampanjaService {

    private final KampanjaRepo kampanjaRepo;

    public KampanjaService(KampanjaRepo kampanjaRepo) {
        this.kampanjaRepo = kampanjaRepo;
    }

    public List<Kampanja> getAll() {
        return kampanjaRepo.findAll();
    }

    public void save(Kampanja kampanja) {
        kampanjaRepo.save(kampanja);
    }

    public Kampanja getById(Long id) {
        return kampanjaRepo.findById(id).orElseThrow();
    }
}
