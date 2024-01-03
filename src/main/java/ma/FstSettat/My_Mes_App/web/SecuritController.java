package ma.FstSettat.My_Mes_App.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecuritController {
    @GetMapping("/403")
    public String notAuthorized(){
        return "403";

    }
}
