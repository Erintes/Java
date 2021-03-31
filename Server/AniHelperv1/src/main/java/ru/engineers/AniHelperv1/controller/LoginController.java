package ru.engineers.AniHelperv1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.engineers.AniHelperv1.User;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("user", new User());

        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute User user, Model model){
        User usr = user;
        usr.setUsername("Your login:" + user.getUsername());
        model.addAttribute("user", usr);

        return "main-page";
    }
}
