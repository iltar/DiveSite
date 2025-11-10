package hh.divesite.DiveSite.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.divesite.DiveSite.domain.RegisterForm;
import hh.divesite.DiveSite.domain.User;
import hh.divesite.DiveSite.domain.UserRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {
    private final UserRepository rep;

    public UserController(UserRepository rep) {
        this.rep = rep;
    }

    @GetMapping({"/", "/welcome"})
    public String getWelcome() {
        return "welcome";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("form", new RegisterForm());
        return "register";
    }

    @GetMapping("/{username}/profile")
    public String getMethodName(@PathVariable("username") String usrName, Model model) {
        model.addAttribute("usr", rep.findByUsername(usrName));
        return "profile";
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

    @PostMapping("/saveUser")
    public String saveUser(@Valid @ModelAttribute() RegisterForm form, BindingResult br) {
        if (br.hasErrors()) {
            return "register";
        }
        if (rep.findByUsername(form.getUsername()) == null) {
            if (rep.findByEmail(form.getEmail()) == null) {
                if (form.passwordMatches()) {
                    String pwd = form.getPassword();
                    BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
                    String hashPwd = bc.encode(pwd);
                    User u = new User(form.getUsername(), hashPwd, form.getEmail(), "USER");
                    rep.save(u);
                    return "redirect:/login";
                } else {
                    br.rejectValue("passwordCheck", "err.passCheck", "Passwords do not match");
                    System.out.println("passwords don't match");
                    return "register";
                }
            } else {
                br.rejectValue("email", "err.email", "Email already in use");
                System.out.println("email in use");
                return "register";
            }
        } else {
            br.rejectValue("username", "err.username", "Username already in use");
            System.out.println("username in use");
            return "register";
        }
    }
}
