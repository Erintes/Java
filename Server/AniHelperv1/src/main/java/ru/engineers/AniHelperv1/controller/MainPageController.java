package ru.engineers.AniHelperv1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.engineers.AniHelperv1.User;

import java.util.List;
import java.util.ArrayList;

@Controller
public class MainPageController {

    @GetMapping("/")
    public String mainPage(){

        return "main-page";
    }

    @GetMapping("/main-page-user")
    public String mainPageUser(Model model){

        return "main-page-user";
    }
}
