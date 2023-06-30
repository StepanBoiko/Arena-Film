package com.company.ArenaFilm.controllers;

import com.company.ArenaFilm.models.Films;
import com.company.ArenaFilm.models.Visitors;
import com.company.ArenaFilm.repos.FilmsRepo;
import com.company.ArenaFilm.repos.VisitorsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VisitorsController {

    @Autowired
    private VisitorsRepo visitorsRepo;
    @Autowired
    private FilmsRepo filmsRepo;

//    @GetMapping("/visitor")
//    public String visitorsMain(Model model) {
//        Iterable<Visitors> visitorsIterable = visitorsRepo.findAll();
//        model.addAttribute("visitorses", visitorsIterable);
//        return "visitor";
//    }

    @GetMapping("/visitor")
    public String visitorsMain(Model model) {
        Iterable<Films> filmsIterable = filmsRepo.findAll();
        model.addAttribute("filmses", filmsIterable);
        return "visitor";
    }

    @RequestMapping (value = {"/visitor"}, method= RequestMethod.POST)
    public String add(@RequestParam String name, @RequestParam String email,
                      @RequestParam String age, @RequestParam String country,
                      Model model){
        Visitors visitors = new Visitors(name, email, age, country);
        visitorsRepo.save(visitors);

        Iterable<Visitors> visitorsIterable = visitorsRepo.findAll();
        model.addAttribute("visitorses", visitorsIterable);
        visitorsIterable = null;
        return "visitor";
    }
    @RequestMapping (value = {"visitor", "filter_year"}, method= RequestMethod.POST)
    public String filter_year(@RequestParam String filter_year,
                         Model model){
        List<Films> filmses = filmsRepo.findByYear(filter_year);
        model.addAttribute("filmses", filmses);
        return "visitor";
    }
    @RequestMapping (value = {"visitor", "filter_genre"}, method= RequestMethod.POST)
    public String filter_genre(@RequestParam String filter_genre,
                         Model model){
        List<Films> filmses = filmsRepo.findByGenre(filter_genre);
        model.addAttribute("filmses", filmses);
        return "visitor";
    }
}
