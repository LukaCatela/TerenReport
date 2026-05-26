package hr.fipu.terenreport.repository;

import hr.fipu.terenreport.model.Kampanja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KampanjaRepo extends JpaRepository<Kampanja, Long> {
}
