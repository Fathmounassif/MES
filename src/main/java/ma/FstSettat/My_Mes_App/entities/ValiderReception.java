package ma.FstSettat.My_Mes_App.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor @Entity
@Getter
@Setter
@NoArgsConstructor

public class ValiderReception {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Valide;
    @Column(name = "Num_Bl")
    private String nom;
    private Long id_reception;


}
