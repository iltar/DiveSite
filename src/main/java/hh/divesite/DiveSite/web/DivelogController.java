package hh.divesite.DiveSite.web;

import java.time.LocalDateTime;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.divesite.DiveSite.domain.Divelog;
import hh.divesite.DiveSite.domain.DivelogRepository;
import hh.divesite.DiveSite.domain.UserRepository;

@Controller
public class DivelogController {
    private final DivelogRepository rep;
    private final UserRepository uRep;

    public DivelogController(DivelogRepository rep, UserRepository uRep) {
        this.rep = rep;
        this.uRep = uRep;
    }

    // http://localhost:8080/divelogs
    @GetMapping("/divelogs")
    @PreAuthorize("hasRole('ADMIN')")
    public String getDivelogs(Model model) {
        model.addAttribute("dls", rep.findAll());
        return "diveloglist";
    }

    @GetMapping("/newDivelog")
    @PreAuthorize("hasRole('ADMIN')")
    public String getNewDivelog(Model model) {
        Divelog dl = new Divelog();
        dl.setTimeAdded(LocalDateTime.now());
        model.addAttribute("dl", dl);
        model.addAttribute("usrs", uRep.findByRole("USER"));
        return "createdivelog";
    }

    @GetMapping("/editDivelog/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String getEditDivelog(@PathVariable() Long id, Model model) {
        model.addAttribute("dl", rep.findById(id));
        model.addAttribute("usrs", uRep.findByRole("USER"));
        return "editdivelog";
    }

    @PostMapping("/saveDivelog")
    @PreAuthorize("hasRole('ADMIN')")
    public String saveDivelog(@ModelAttribute Divelog dl) {
        rep.save(dl);
        return "redirect:/divelogs";
    }

    @GetMapping("/deleteDivelog/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteDivelog(@PathVariable() Long id) {
        rep.deleteById(id);
        return "redirect:/divelogs";
    }
}
