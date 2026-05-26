package hr.fipu.terenreport.repository;

import hr.fipu.terenreport.model.Point;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepo extends JpaRepository<Point, Long> {
}
