package ru.engineers.AniHelperv1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.engineers.AniHelperv1.Cipher;
import ru.engineers.AniHelperv1.User;
import ru.engineers.AniHelperv1.enteties.Users;
import ru.engineers.AniHelperv1.services.UserService;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("logUser", new User());

        return "login";
    }

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public String loginSubmit(Model model,//
            @ModelAttribute("logUser") User logUser){

        Users usr = userService.findByLogin(logUser.getUsername());
        if(usr != null)
        {
            int pswd = Cipher.getHash(logUser.getPassword());
            if(usr.getPassword() == pswd) {
                if(logUser.getUsername().equals("admin")) return "main-admin-page";

                model.addAttribute("user", logUser);
                return "main-page-user";
            }
        }

        return "login";
    }
}
