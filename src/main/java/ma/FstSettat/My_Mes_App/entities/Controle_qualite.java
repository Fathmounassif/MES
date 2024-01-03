package ma.FstSettat.My_Mes_App.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor @Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "controle_qualite")
public class Controle_qualite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_operation;
    @Column(name = "username")
    private String nom;
    @ManyToOne
    @JoinColumn(name = "id_bobine")
    private Produits produits;
    private boolean echantillan=false;
    private String declarer;
    private boolean valide=false;


}
