package ma.FstSettat.My_Mes_App.security.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class AppRole {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long roleId;
    @Column(unique = true)
    @NotEmpty
    private String rolename;
    private String description;
}
