package ru.engineers.AniHelperv1.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {

    @GetMapping("/index")
    public String index(){

        return "index";
    }
}
