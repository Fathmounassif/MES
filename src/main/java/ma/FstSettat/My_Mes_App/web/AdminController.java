package ma.FstSettat.My_Mes_App.web;

import lombok.AllArgsConstructor;
import ma.FstSettat.My_Mes_App.Respsotories.FornisseurRepository;
import ma.FstSettat.My_Mes_App.Respsotories.ProduitsRepository;
import ma.FstSettat.My_Mes_App.Respsotories.ResponsableQualityRepository;
import ma.FstSettat.My_Mes_App.entities.*;
import ma.FstSettat.My_Mes_App.security.Repositories.AppRoleRepository;
import ma.FstSettat.My_Mes_App.security.Repositories.AppUserRepository;
import ma.FstSettat.My_Mes_App.security.entities.AppRole;
import ma.FstSettat.My_Mes_App.security.entities.AppUser;
import ma.FstSettat.My_Mes_App.security.sevice.SecurityServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class AdminController {
    private SecurityServiceImpl securityService;
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;

    @PostMapping(path = "/admin/saveUser")
    private String saveUser(Model model, @Valid AppUser appUser, Long userId, String username, String password, String repassword, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "AjouterUser";
        securityService.saveNewUser(userId, username, password, repassword);

        return "redirect:/";
    }

    @PostMapping(path = "/admin/saveRole")
    private String saveRole(Model model, @Valid String rolename, @Valid AppRole appRole, @Valid String description, Errors error) {
        if (error.hasErrors()) return "AjouterRole";
        securityService.saveNewRole(rolename, description);

        return "redirect:/";
    }

    @PostMapping(path = "/admin/saveUserRole")
    private String saveUserRole(Model model, @Valid AppRole appRole, @Valid AppUser appUser, String rolename, String username, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "AddUserRole";
        securityService.addRoleToUser(username, rolename);
        return "redirect:/";
    }

    @GetMapping(path = "/admin/AddUser")
    public String AjouterUser(Model model) {
        model.addAttribute("user", new AppUser());
        return "AjouterUser";
    }

    @GetMapping(path = "/admin/AddRole")
    public String AjouterRole(Model model) {
        model.addAttribute("role", new AppRole());
        return "AjouterRole";
    }

    @GetMapping(path = "/admin/UserRole")
    public String AddUserRoles(Model model) {
        model.addAttribute("user", new AppUser());
        model.addAttribute("role", new AppRole());
        return "AddUserRole";
    }

    @GetMapping(path = "/admin/deleteRole")
    public String deleteRole(long roleId) {
        appRoleRepository.deleteById(roleId);
        return "redirect:/admin/DeleteRole";
    }
    @GetMapping(path = "/admin/DeleteRole")
    public  String DeleteRole (Model model){
        List<AppRole> roles= appRoleRepository.findAll();
        model.addAttribute("listRoles",roles);

        return "Roles";
    }
    @GetMapping(path = "/admin/deleteUser")
    public String deleteUser(long userId) {
        appUserRepository.deleteById(userId);
        return "redirect:/admin/DeleteUser";
    }
    @GetMapping(path = "/admin/DeleteUser")
    public  String DeleteUser (Model model){
        List<AppUser> users= appUserRepository.findAll();
        model.addAttribute("listUsers",users);

        return "Users";
    }
}
