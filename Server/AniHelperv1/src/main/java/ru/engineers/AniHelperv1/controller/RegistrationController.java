package ru.engineers.AniHelperv1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.engineers.AniHelperv1.User;

@Controller
public class RegistrationController {

    @GetMapping("/registration")
    public String registrationForm(Model model){
        model.addAttribute("user", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registrationSubmit(@ModelAttribute User user, Model model){
        model.addAttribute("user", user);

        return "main-page";
    }
}
