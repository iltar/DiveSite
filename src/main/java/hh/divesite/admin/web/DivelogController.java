package hh.divesite.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hh.divesite.admin.domain.Divelog;
import hh.divesite.admin.domain.DivelogRepository;




@Controller
public class DivelogController {
    private final DivelogRepository rep;

    public DivelogController(DivelogRepository rep) {
        this.rep = rep;
    }

    //http://localhost:8080/divelogs
    @GetMapping("/divelogs")
    public String getDivelogs(Model model) {
        model.addAttribute("dls", rep.findAll());
        return "diveloglist";
    }
    
    @GetMapping("/newDivelog")
    public String getNewDivelog(Model model) {
        model.addAttribute("dl", new Divelog());
        return "createdivelog";
    }

    @PostMapping("/saveDivelog")
    public String postMethodName(@ModelAttribute Divelog dl) {
        rep.save(dl);
        return "redirect:/divelogs";
    }
    
    
}
