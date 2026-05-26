package hr.fipu.terenreport.repository;

import hr.fipu.terenreport.model.Kampanja;
import hr.fipu.terenreport.model.Point;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PointRepo extends JpaRepository<Point, Long> {
    List<Point> findByKampanja(Kampanja kampanja);
}

