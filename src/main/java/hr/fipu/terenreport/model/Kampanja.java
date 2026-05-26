package hr.fipu.terenreport.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Kampanja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_kampanja;

    private String naziv;

    @Column(length = 1000)
    private String opis;

    private LocalDate datumPocetka;

    private LocalDate datumKraja;

    private String status;
}
