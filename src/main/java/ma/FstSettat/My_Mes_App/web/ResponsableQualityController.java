package ma.FstSettat.My_Mes_App.web;

import lombok.AllArgsConstructor;
import ma.FstSettat.My_Mes_App.Respsotories.*;
import ma.FstSettat.My_Mes_App.entities.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class ResponsableQualityController {


    private ResponsableQualityRepository responsableQualityRepository; //accéder a la base de donnés

    @GetMapping(path = "/recepensable_qualite/validation")
    public String RcepensableQualite(Model model,
                                     @RequestParam(name = "page", defaultValue = "0") int page,
                                     @RequestParam(name = "size", defaultValue = "6") int size,
                                     @RequestParam(name = "keyword", defaultValue = "") String keyword) {

        Page<Controle_qualite> pageReceptionResponsable = responsableQualityRepository.findByNomContains(keyword, PageRequest.of(page, size));
        model.addAttribute("listReceptionsResponsable", pageReceptionResponsable.getContent());
        model.addAttribute("pages", new int[pageReceptionResponsable.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);

        return "Responsable_qualite";

    }



@GetMapping(path = "recepensable_qualite/update/{id_operation}")
public String update(@PathVariable("id_operation") Long id_operation,Model model, int page, String keyword){
    responsableQualityRepository.update(id_operation);
    Controle_qualite controle_qualite = responsableQualityRepository.findById(id_operation).orElse(null);
    Produits produits = produitsRepository.findById(id_operation).orElse(null);
    Fornisseur fornisseur = fornisseurRepository.findById(id_operation).orElse(null);
    if (controle_qualite == null) throw new RuntimeException("Reception intrevable");
    model.addAttribute("produits",produits);
    model.addAttribute("fornisseur",fornisseur);
    model.addAttribute("responsable",controle_qualite);
    model.addAttribute("page",page);
    model.addAttribute("keyword",keyword);
    return "Visualiser";
}


    ProduitsRepository produitsRepository;
    FornisseurRepository fornisseurRepository;

    @GetMapping(path = "/recepensable_qualite/deleteValide")
    public String deleteValide(long id_operation) {
        responsableQualityRepository.deleteById(id_operation);
        return "redirect:/recepensable_qualite/validation";
    }
}
