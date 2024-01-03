package ma.FstSettat.My_Mes_App.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@AllArgsConstructor @Entity
@Getter
@Setter
@NoArgsConstructor

public class Produits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_bobine;
    private String Famile_produit;
    private int Largeur;
    private int Epesseur;
    private String Nuance;
    private boolean Ajouter;
}