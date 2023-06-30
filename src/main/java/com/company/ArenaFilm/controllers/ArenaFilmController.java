package com.company.ArenaFilm.controllers;

import com.company.ArenaFilm.models.Films;
import com.company.ArenaFilm.repos.FilmsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class ArenaFilmController {

    @Autowired
    private FilmsRepo filmsRepo;



    @GetMapping("/home")
    public String filmsMain(Model model) {
        Iterable<Films> filmsIterable = filmsRepo.findAll();
        model.addAttribute("filmses", filmsIterable);
        return "home";
    }

    @GetMapping("/")
    public String Main(Model model) {
        return "/home";
    }

    @RequestMapping (value = {"/"}, method= RequestMethod.POST)
    public String add(@RequestParam String name, @RequestParam String year,
                      @RequestParam String genre, @RequestParam String country,
                      @RequestParam String company, @RequestParam String rating,
                      @RequestParam String duration, @RequestParam String ageLimit,
                      Model model){
        Films films = new Films(name, year, genre, country, company, rating, duration, ageLimit);
        filmsRepo.save(films);

        Iterable<Films> filmsIterable = filmsRepo.findAll();
        System.out.println(filmsIterable);
        model.addAttribute("filmses", filmsIterable);
        filmsIterable = null;
        return "home";
    }
    @RequestMapping (value = {"/home"}, method= RequestMethod.POST)
    public String addHome(@RequestParam String name, @RequestParam String year,
                      @RequestParam String genre, @RequestParam String country,
                      @RequestParam String company, @RequestParam String rating,
                      @RequestParam String duration, @RequestParam String ageLimit,
                      Model model){
        Films films = new Films(name, year, genre, country, company, rating, duration, ageLimit);
        filmsRepo.save(films);

        Iterable<Films> filmsIterable = filmsRepo.findAll();
        System.out.println(filmsIterable);
        model.addAttribute("filmses", filmsIterable);
        filmsIterable = null;
        return "home";
    }
}
