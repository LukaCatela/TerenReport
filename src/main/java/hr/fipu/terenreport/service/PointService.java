package hr.fipu.terenreport.service;

import hr.fipu.terenreport.model.Kampanja;
import hr.fipu.terenreport.model.Point;
import hr.fipu.terenreport.repository.PointRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointService {

    private final PointRepo pointRepo;

    public PointService(PointRepo pointRepo) {
        this.pointRepo = pointRepo;
    }

    public List<Point> getAll() {
        return pointRepo.findAll();
    }

    public List<Point> getByKampanja(Kampanja kampanja) {
        return pointRepo.findByKampanja(kampanja);
    }

    public Point getById(Long id) {
        return pointRepo.findById(id).orElseThrow();
    }

    public void save(Point point) {
        pointRepo.save(point);
    }
}
