package ma.FstSettat.My_Mes_App.security.Repositories;


import ma.FstSettat.My_Mes_App.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUsername(String username);
}
