package ru.engineers.AniHelperv1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.engineers.AniHelperv1.services.SecurityService;

@Controller
public class MainPageController {

    @GetMapping("/")
    public String mainPage(){

        return "main-page";
    }

    @RequestMapping(value="/add-anime-page")
    public String addAnimePage(){
        return "add-anime-page";
    }

    @RequestMapping(value="/403")
    public String Error403(){
        return "403";
    }

    @Autowired
    private SecurityService securityService;

    @GetMapping("/login")
    public String login() {
        if (securityService.isAuthenticated()) {
            return "redirect:/";
        }

        return "login";
    }
}
