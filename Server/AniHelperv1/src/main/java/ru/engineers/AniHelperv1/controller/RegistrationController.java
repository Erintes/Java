package ru.engineers.AniHelperv1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.engineers.AniHelperv1.enteties.User;
import ru.engineers.AniHelperv1.services.SecurityService;
import ru.engineers.AniHelperv1.services.UserService;

@Controller
public class RegistrationController {

    @Autowired
    private SecurityService securityService;

    @GetMapping("/registration")
    public String registrationForm(Model model){
        if (securityService.isAuthenticated()) {
            return "redirect:/";
        }

        model.addAttribute("regUser", new User());

        return "registration";
    }

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public String registrationSubmit(Model model,//
                                     @ModelAttribute("regUser") User regUser){

        if (!userService.saveUser(regUser)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";
        }

        return "redirect:/";
    }
}
