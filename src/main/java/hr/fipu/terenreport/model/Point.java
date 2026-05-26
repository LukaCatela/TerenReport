package hr.fipu.terenreport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonIgnore
    private Kampanja kampanja;

    @ManyToOne
    @JoinColumn(name = "od_tocke_id")
    @JsonIgnore
    private Point odTocke;

    @ManyToOne
    @JoinColumn(name = "do_tocke_id")
    @JsonIgnore
    private Point doTocke;

    @JsonProperty("odTockeId")
    public Long getOdTockeId() {
        return odTocke != null ? odTocke.getId_point() : null;
    }

    @JsonProperty("doTockeId")
    public Long getDoTockeId() {
        return doTocke != null ? doTocke.getId_point() : null;
    }
}
