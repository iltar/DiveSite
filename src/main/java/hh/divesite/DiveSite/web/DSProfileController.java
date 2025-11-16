package hh.divesite.DiveSite.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import hh.divesite.DiveSite.domain.DivelogRepository;
import hh.divesite.DiveSite.domain.Profile;
import hh.divesite.DiveSite.domain.User;
import hh.divesite.DiveSite.domain.UserRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DSProfileController {
    private final UserRepository rep;
    private final DivelogRepository dlRep;

    public DSProfileController(UserRepository rep, DivelogRepository dlRep) {
        this.rep = rep;
        this.dlRep = dlRep;
    }

    @GetMapping("/{username}/profile")
    public String getProfile(@PathVariable("username") String usrName, Model model) {
        User usr = rep.findByUsername(usrName);
        model.addAttribute("usr", new Profile(usr));
        model.addAttribute("logs", dlRep.findAllByDiverOrderByDiveNumberDesc(usr));
        return "profile";
    }

    @GetMapping("/{username}/editProfile")
    public String getEditProfile(@PathVariable("username") String usrName, Model model) {
        User usr = rep.findByUsername(usrName);
        model.addAttribute("usr", new Profile(usr));
        model.addAttribute("logs", dlRep.findAllByDiverOrderByDiveNumberDesc(usr));
        return "editprofile";
    }

    @PostMapping("/{username}/saveProfile")
    public String postEditedProfile(@Valid @ModelAttribute("usr") Profile profile, BindingResult br,
            @PathVariable() String username) {
        if (br.hasErrors()) {
            return "editprofile";
        }
        User usr = rep.findByUsername(username);
        usr.setDescription(profile.getDescription());
        usr.setDives(profile.getDives());
        usr.setLevel(profile.getLevel());
        rep.save(usr);
        return "redirect:/{username}/profile";
    }

}
