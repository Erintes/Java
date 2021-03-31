package ru.engineers.AniHelperv1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.engineers.AniHelperv1.User;

@Controller
public class MainPageController {

    //@GetMapping("/main-page")
    public String mainPage(){

        return "main-page";
    }
}
