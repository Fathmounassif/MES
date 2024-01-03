package ma.FstSettat.My_Mes_App.security.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long userId;
    @Column(unique = true)
    @NotEmpty
    private String username;
    @NotEmpty//ne doit pas être vide
    private String password;
    @NotEmpty
    private String repassword;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "rolename")
    private List<AppRole> appRoles=new ArrayList<>();
}
