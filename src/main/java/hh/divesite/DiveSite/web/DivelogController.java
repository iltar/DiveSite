package hh.divesite.DiveSite.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.divesite.DiveSite.domain.Divelog;
import hh.divesite.DiveSite.domain.DivelogRepository;
import hh.divesite.DiveSite.domain.User;
import hh.divesite.DiveSite.domain.UserRepository;
import jakarta.validation.Valid;

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
        Divelog dl = new Divelog(1);
        model.addAttribute("dl", dl);
        model.addAttribute("usrs", uRep.findAllByRole("USER"));
        return "createdivelog";
    }

    @GetMapping("/editDivelog/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String getEditDivelog(@PathVariable() Long id, Model model) {
        model.addAttribute("dl", rep.findByDivelogId(id));
        model.addAttribute("usrs", uRep.findAllByRole("USER"));
        return "editdivelog";
    }

    @PostMapping("/saveNewDivelog")
    @PreAuthorize("hasRole('ADMIN')")
    public String postNewDivelog(@Valid @ModelAttribute("dl") Divelog dl,
            BindingResult br, Model model) {
        model.addAttribute("usrs", uRep.findAllByRole("USER"));
        if (!br.hasErrors()) {
            User usr = dl.getDiver();
            int i = dl.getDiveNumber();
            List<Divelog> dls = rep.findAllByDiver(usr);
            for (Divelog log : dls) {
                // check that user has no dive with same dive number
                if (log.getDiveNumber() == i) {
                    br.rejectValue("diveNumber", "err.diveNumber",
                            "Dive #" + i + " already exists for user " + usr.getUsername() + ".");
                    return "createdivelog";
                }
                // check that dives with smaller dive number happened before this dive
                if (i < log.getDiveNumber() && dl.getDiveDate().isAfter(log.getDiveDate())) {
                    br.rejectValue("diveDate", "err.diveDate",
                            "User " + usr.getUsername() + "'s dive #" + i + " cannot occur after dive #"
                                    + log.getDiveNumber());
                    return "createdivelog";
                }
                // check that dives with bigger dive number happened after this dive
                if (i > log.getDiveNumber() && dl.getDiveDate().isBefore(log.getDiveDate())) {
                    br.rejectValue("diveDate", "err.diveDate",
                            "User " + usr.getUsername() + "'s dive #" + i + " cannot occur before dive #"
                                    + log.getDiveNumber());
                    return "createdivelog";
                }
            }
            if (i > usr.getDives()) {
                usr.setDives(i);
            }
            rep.save(dl);
            return "redirect:/divelogs";
        }
        return "createdivelog";
    }

    @PostMapping("/saveEditedDivelog/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String postEditedDivelog(@Valid @ModelAttribute("dl") Divelog dl, BindingResult br,
            @PathVariable("id") Long id, Model model) {
        model.addAttribute("usrs", uRep.findAllByRole("USER"));
        if (!br.hasErrors()) {
            User usr = dl.getDiver();
            int i = dl.getDiveNumber();
            List<Divelog> dls = rep.findAllByDiver(usr);
            for (Divelog log : dls) {
                // check that user has no dive with same dive number
                if (log.getDiveNumber() == i && log.getDivelogId() != id) {
                    br.rejectValue("diveNumber", "err.diveNumber",
                            "Dive #" + i + " already exists for user " + usr.getUsername() + ".");
                    return "editdivelog";
                }
                // check that dives with smaller dive number happened before this dive
                if (i < log.getDiveNumber() && dl.getDiveDate().isAfter(log.getDiveDate())) {
                    br.rejectValue("diveDate", "err.diveDate",
                            "User " + usr.getUsername() + "'s dive #" + i + " cannot occur after dive #"
                                    + log.getDiveNumber());
                    return "editdivelog";
                }
                // check that dives with bigger dive number happened after this dive
                if (i > log.getDiveNumber() && dl.getDiveDate().isBefore(log.getDiveDate())) {
                    br.rejectValue("diveDate", "err.diveDate",
                            "User " + usr.getUsername() + "'s dive #" + i + " cannot occur before dive #"
                                    + log.getDiveNumber());
                    return "editdivelog";
                }
            }
            if (i > usr.getDives()) {
                usr.setDives(i);
            }
            rep.save(dl);
            return "redirect:/divelogs";
        }
        return "editdivelog";
    }

    @GetMapping("/deleteDivelog/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteDivelog(@PathVariable() Long id) {
        rep.deleteById(id);
        return "redirect:/divelogs";
    }
}
