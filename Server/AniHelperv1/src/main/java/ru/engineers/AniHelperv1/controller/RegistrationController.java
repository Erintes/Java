package ru.engineers.AniHelperv1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.engineers.AniHelperv1.Cipher;
import ru.engineers.AniHelperv1.User;
import ru.engineers.AniHelperv1.enteties.Users;
import ru.engineers.AniHelperv1.services.UserService;

import java.nio.charset.StandardCharsets;

@Controller
public class RegistrationController {

    @GetMapping("/registration")
    public String registrationForm(Model model){
        model.addAttribute("regUser", new User());

        return "registration";
    }

    @Autowired
    UserService userService;

    @PostMapping("/registration")
    public String registrationSubmit(Model model,//
                                     @ModelAttribute("regUser") User regUser){

        if (userService.findByLogin(regUser.getUsername()) != null) return "registration";

        var pswd = Cipher.getHash(regUser.getPassword());

        Users usr = new Users(regUser.getUsername(), pswd);
        userService.createUsers(usr);

        return "redirect:/login";
    }
}
