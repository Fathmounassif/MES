package ma.FstSettat.My_Mes_App.web;

import lombok.AllArgsConstructor;
import ma.FstSettat.My_Mes_App.Respsotories.FornisseurRepository;
import ma.FstSettat.My_Mes_App.Respsotories.ProduitsRepository;
import ma.FstSettat.My_Mes_App.Respsotories.ReceptionRepository;
import ma.FstSettat.My_Mes_App.Respsotories.ValiderReceptionRepository;
import ma.FstSettat.My_Mes_App.entities.*;
import ma.FstSettat.My_Mes_App.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@AllArgsConstructor
public class ReceptionController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    //@Autowired //gerer les ingection des dépandances
    @Autowired
    private Service serviceReception;
    private ReceptionRepository receptionRepository; //accéder a la base de donnés
    @GetMapping (path ="/magasinier/reception")
   public  String Receptions (Model model,
                          @RequestParam(name = "page",defaultValue = "0") int page,
                           @RequestParam(name = "size",defaultValue = "6")   int size,
                              @RequestParam(name = "keyword",defaultValue = "") String keyword  ){

        Page<Reception> pageReception= receptionRepository.findByNomContains(keyword,PageRequest.of(page,size));
        Page<ValiderReception> pageVReception= validerReceptionRepository.findByNomContains(keyword,PageRequest.of(page,size));
        model.addAttribute("listReceptions",pageReception.getContent());
        model.addAttribute("valide",pageVReception.getContent());
        model.addAttribute("pages",new  int[pageReception.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);

        return "Reception";

    }




@GetMapping(path = "magasinier/update/{id_reception}")
public String update(@PathVariable("id_reception") Long id_reception,Model model, int page, String keyword){
  receptionRepository.update(id_reception);
    Reception reception = receptionRepository.findById(id_reception).orElse(null);
    Produits produits = produitsRepository.findById(id_reception).orElse(null);
    Fornisseur fornisseur = fornisseurRepository.findById(id_reception).orElse(null);
    List<ValiderReception> validerReception = validerReceptionRepository.findAll();
    if (reception == null) throw new RuntimeException("Reception intrevable");
    model.addAttribute("produits",produits);
    model.addAttribute("valide",validerReception);
    model.addAttribute("fornisseur",fornisseur);
    model.addAttribute("reception",reception);
    model.addAttribute("page",page);
    model.addAttribute("keyword",keyword);
    model.addAttribute("valideReception",new ValiderReception());
    return "Valider";

}



/*

    @GetMapping(path = "/isValider/{num_bl}")
    public String isValidation(@PathVariable String num_bl,Model model){
        List<Reception> receptionList =receptionRepository.findAll();
        for(Reception reception:receptionList){
            if(reception.getNom()==num_bl){
            if(reception.isValide()){
              return "true";
            }}
            return "false";
        }

         return "redirect:/reception";
    }*/
    /*
      private MagazineRepository magazineRepository;
       @GetMapping(path="/magasinier")
       public String magazinier(Model model){
           List<Magazinier> magazinierList=magazineRepository.findAll();
           model.addAttribute("listMagasinier",magazinierList);
        return "Mag";
       }*/
    @GetMapping(path = "/")
    public String home(){

        return "home";//une rederction apres delete.
    }

    ProduitsRepository produitsRepository;
    FornisseurRepository fornisseurRepository;
  /*  @GetMapping(path = "/magasinier/valide")
    public String editReception(Model model,long id,String keyword,int page) {
        Reception reception = receptionRepository.findById(id).orElse(null);
        Produits produits = produitsRepository.findById(id).orElse(null);
        Fornisseur fornisseur = fornisseurRepository.findById(id).orElse(null);
        if (reception == null) throw new RuntimeException("Reception intrevable");
        model.addAttribute("produits",produits);
        model.addAttribute("fornisseur",fornisseur);
        model.addAttribute("reception",reception);
        model.addAttribute("page",page);
        model.addAttribute("keyword",keyword);
        return "Valider";}*/

 ValiderReceptionRepository validerReceptionRepository;
    @PostMapping(path = "/magasinier/save")
    private String save(Model model,  ValiderReception validerReception, BindingResult bindingResult,
                        @RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "") String keyword){
        if(bindingResult.hasErrors()) return "Valider";//test si un error de validation.
        validerReceptionRepository.save(validerReception);
        return "redirect:/magasinier/reception?page="+page+"&keyword"+keyword;
    }


  /*  @GetMapping(path = "/magasinier/validee")
    public String formPatient(Model model,long id,String keyword,int page) {
        Reception reception = receptionRepository.findById(id).orElse(null);
        Produits produits = produitsRepository.findById(id).orElse(null);
        Fornisseur fornisseur = fornisseurRepository.findById(id).orElse(null);
        ValiderReception validerReception = validerReceptionRepository.findById(id).orElse(null);
        if (reception == null) throw new RuntimeException("Reception intrevable");
        model.addAttribute("produits",produits);
        model.addAttribute("valide",validerReception);
        model.addAttribute("fornisseur",fornisseur);
        model.addAttribute("reception",reception);
        model.addAttribute("page",page);
        model.addAttribute("keyword",keyword);
        model.addAttribute("patient",new ValiderReception());
        return "Valider";}*/

     /*@PostMapping(path = "/magasinier/uupdate")
   public Reception uupdate(Reception reception){
         Reception exit= receptionRepository.getById(reception.getId_reception());
         if(reception.getId_reception()!=null){
             exit.setId_reception(reception.getId_reception());
         }if(reception.getDate_de_reception()!=null){
           exit.setDate_de_reception(reception.getDate_de_reception());
       } if(reception.getNom()!=null){
           exit.setNom(reception.getNom());
       } if(reception.getFornisseur().getId_fornisseur()!=null){
           exit.setFornisseur(reception.getFornisseur());
       } if(reception.getProduits().getId_bobine()!=null){
           exit.setProduits(reception.getProduits());
       } if(reception.isValide()!=true){
           exit.setValide(reception.isValide()==true);
       }
         return receptionRepository.save(exit);
   }*/



/*
    @PostMapping(path = "/magasinier/saveupdate")
    private String saveupdate(Model model,  Reception reception ,BindingResult bindingResult,
                        @RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "") String keyword){
        if(bindingResult.hasErrors()) return "Valider";//test si un error de validation.
        serviceReception.updateReception(reception.getId_reception());
      /*  serviceReception.sendEmail(reception.getId_reception(),"mounassif.fst@uhp.ac.ma","Merci de valider les bobine","demande de validation")
        return "redirect:/magasinier/reception?page="+page+"&keyword"+keyword;}*/


}
