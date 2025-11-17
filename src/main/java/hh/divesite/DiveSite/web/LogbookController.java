package hh.divesite.DiveSite.web;

import java.util.List;

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
public class LogbookController {

    private final DivelogRepository rep;
    private final UserRepository uRep;

    public LogbookController(DivelogRepository rep, UserRepository uRep) {
        this.rep = rep;
        this.uRep = uRep;
    }

    @GetMapping("/{username}/newDivelog")
    public String getNewDivelog(@PathVariable() String username, Model model) {
        User usr = uRep.findByUsername(username);
        Divelog dl = new Divelog(usr.getDives() + 1);
        dl.setDiver(usr);
        model.addAttribute("dl", dl);
        return "addtologbook";
    }

    @GetMapping("/{username}/editDivelog/{id}")
    public String getEditDivelog(@PathVariable() String username, @PathVariable() Long id, Model model) {
        User usr = uRep.findByUsername(username);
        Divelog dl = rep.findByDivelogId(id);
        dl.setDiver(usr);
        model.addAttribute("dl", dl);
        model.addAttribute("username", username);
        return "editinlogbook";
    }

    @PostMapping("/{username}/saveNewDivelog")
    public String postNewDivelog(@Valid @ModelAttribute("dl") Divelog dl,
            BindingResult br, @PathVariable("username") String usrName) {
        if (!br.hasErrors()) {
            User usr = uRep.findByUsername(usrName);
            int i = dl.getDiveNumber();
            List<Divelog> dls = rep.findAllByDiver(usr);
            for (Divelog log : dls) {
                // check that user has no dive with same dive number
                if (log.getDiveNumber() == i) {
                    br.rejectValue("diveNumber", "err.diveNumber", "Dive #" + i + " already exists.");
                    return "addtologbook";
                }
                // check that dives with smaller dive number happened before this dive
                if (i < log.getDiveNumber() && dl.getDiveDate().isAfter(log.getDiveDate())) {
                    br.rejectValue("diveDate", "err.diveDate",
                            "Dive #" + i + " cannot occur after dive #" + log.getDiveNumber());
                    return "addtologbook";
                }
                // check that dives with bigger dive number happened after this dive
                if (i > log.getDiveNumber() && dl.getDiveDate().isBefore(log.getDiveDate())) {
                    br.rejectValue("diveDate", "err.diveDate",
                            "Dive #" + i + " cannot occur before dive #" + log.getDiveNumber());
                    return "addtologbook";
                }
            }
            if (i > usr.getDives()) {
                usr.setDives(i);
            }
            rep.save(dl);
            return "redirect:/{username}/profile";
        }
        return "addtologbook";
    }

    @PostMapping("/{username}/saveEditedDivelog/{id}")
    public String postEditedDivelog(@Valid @ModelAttribute("dl") Divelog dl,
            BindingResult br, @PathVariable("username") String usrName, @PathVariable("id") Long id) {
        if (!br.hasErrors()) {
            User usr = uRep.findByUsername(usrName);
            int i = dl.getDiveNumber();
            List<Divelog> dls = rep.findAllByDiver(usr);
            for (Divelog log : dls) {
                // check that user has no dive with same dive number
                if (log.getDiveNumber() == i && id != log.getDivelogId()) {
                    br.rejectValue("diveNumber", "err.diveNumber", "Dive #" + i + " already exists.");
                    return "editinlogbook";
                }
                // check that dives with smaller dive number happened before this dive
                if (i < log.getDiveNumber() && dl.getDiveDate().isAfter(log.getDiveDate())) {
                    br.rejectValue("diveDate", "err.diveDate",
                            "Dive #" + i + " cannot occur after dive #" + log.getDiveNumber());
                    return "editinlogbook";
                }
                // check that dives with bigger dive number happened after this dive
                if (i > log.getDiveNumber() && dl.getDiveDate().isBefore(log.getDiveDate())) {
                    br.rejectValue("diveDate", "err.diveDate",
                            "Dive #" + i + " cannot occur before dive #" + log.getDiveNumber());
                    return "editinlogbook";
                }
            }
            if (i > usr.getDives()) {
                usr.setDives(i);
            }
            rep.save(dl);
            return "redirect:/{username}/profile";
        }
        return "editinlogbook";
    }

    @GetMapping("/{username}/deleteDivelog/{id}")
    public String deleteDivelog(@PathVariable() String username, @PathVariable() Long id) {
        rep.deleteById(id);
        return "redirect:/{username}/profile";
    }
}
