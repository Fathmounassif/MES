package ma.FstSettat.My_Mes_App.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor @Entity
@Getter
@Setter
@NoArgsConstructor

public class Fornisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_fornisseur;
    private String nom_fornisseur;
}
