package hh.divesite.DiveSite.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import hh.divesite.DiveSite.domain.UserRepository;

@Controller
public class UserController {
    private final UserRepository rep;

    public UserController(UserRepository rep) {
        this.rep = rep;
    }

    @GetMapping({ "/", "/welcome" })
    public String getWelcome() {
        return "welcome";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute(null);
        return "register";
    }

    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public String getUsers(Model model) {
        model.addAttribute("usrs", rep.findByRole("USER"));
        return "userlist";
    }

    @GetMapping("/deleteUser/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteUser(@PathVariable() Long id) {
        rep.deleteById(id);
        return "redirect:/users";
    }
}
