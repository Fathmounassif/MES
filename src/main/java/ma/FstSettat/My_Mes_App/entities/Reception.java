package ma.FstSettat.My_Mes_App.entities;
import lombok.*;
import ma.FstSettat.My_Mes_App.Respsotories.ReceptionRepository;
import ma.FstSettat.My_Mes_App.entities.Fornisseur;
import ma.FstSettat.My_Mes_App.entities.Produits;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@AllArgsConstructor @Entity
@Getter
@Setter
@NoArgsConstructor

public class Reception{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reception;
    @Column(name = "Num_Bl")
    private String nom;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date Date_de_reception;
    @ManyToOne
    @JoinColumn(name = "id_fornisseur")
    private Fornisseur fornisseur;
    @ManyToOne
    @JoinColumn(name = "id_bobine")
    private Produits produits;
    private String N_de_lot;
    private String Qte_en_KG;
    private boolean valide=false;


}
