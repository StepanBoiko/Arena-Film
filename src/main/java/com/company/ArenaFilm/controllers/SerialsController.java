package com.company.ArenaFilm.controllers;

import com.company.ArenaFilm.models.Films;
import com.company.ArenaFilm.models.Serials;
import com.company.ArenaFilm.repos.SerialsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SerialsController {

    @Autowired
    private SerialsRepo serialsRepo;

    @GetMapping("/serials")
    public String serialsMain(Model model){
        Iterable<Serials> serialsIterable = serialsRepo.findAll();
        model.addAttribute("serialses", serialsIterable);
        return "serials";
    }

    @RequestMapping(value = {"/serials"}, method= RequestMethod.POST)
    public String add(@RequestParam String name, @RequestParam String seasons,
                      @RequestParam String series, @RequestParam String year,
                      @RequestParam String voice, @RequestParam String rating,
                      Model model){
        Serials serials = new Serials(name, seasons, series, year, voice, rating);
        serialsRepo.save(serials);

        Iterable<Serials> serialsIterable = serialsRepo.findAll();
        model.addAttribute("serialses", serialsIterable);
        serialsIterable = null;
        return "serials";
    }
}
