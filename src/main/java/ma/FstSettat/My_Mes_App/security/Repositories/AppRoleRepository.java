package ma.FstSettat.My_Mes_App.security.Repositories;


import ma.FstSettat.My_Mes_App.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    AppRole findByRolename(String roleName);
}
