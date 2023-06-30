package com.company.ArenaFilm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MarvelController {
    @RequestMapping(value="/marvel")
    public String marvelMain(Model model){
        model.addAttribute("marvel","marvelPage");
        return "marvel";
    }
}
