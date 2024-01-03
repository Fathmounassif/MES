package ma.FstSettat.My_Mes_App.security.sevice;


import ma.FstSettat.My_Mes_App.security.entities.AppRole;
import ma.FstSettat.My_Mes_App.security.entities.AppUser;

public interface SecurityService {
    AppUser saveNewUser(Long id,String username, String password, String rePassword);
    AppRole saveNewRole(String roleName, String description);
    void addRoleToUser(String username,String roleName);
    void removeRoleFromUser(String username,String roleName);
    AppUser loadUserByUserName(String username);
}
