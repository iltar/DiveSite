package hh.divesite.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.divesite.admin.domain.DivelogRepository;


@Controller
public class DivelogController {
    private final DivelogRepository rep;

    public DivelogController(DivelogRepository rep) {
        this.rep = rep;
    }

    //http://localhost:8080/divelogs
    @GetMapping("/divelogs")
    public String getMethodName(Model model) {
        model.addAttribute("dls", rep.findAll());
        return "diveloglist";
    }
    
}
