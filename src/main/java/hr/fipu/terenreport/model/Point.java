package hr.fipu.terenreport.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_point;

    private String brojTocke;

    private double E;
    private double N;
    private double h;

    @Enumerated(EnumType.STRING)
    private VrstaTocke vrsta;

    private String metodaMjerenja;
    private double tocnost;

    private LocalDateTime datumMjerenja;

    @Column(length = 500)
    private String napomena;

    @ManyToOne
    @JoinColumn(name = "id_kampanja")
    private Kampanja kampanja;
}
