package com.company.ArenaFilm.controllers;

import com.company.ArenaFilm.models.Collections;
import com.company.ArenaFilm.models.Films;
import com.company.ArenaFilm.repos.CollectionsRepo;
import com.company.ArenaFilm.repos.FilmsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CollectionsController {
    @Autowired
    private CollectionsRepo collectionsRepo;

    @GetMapping("/mycollections")
    public String collectionsMain(Model model) {
        Iterable<Collections> collectionsIterable = collectionsRepo.findAll();
        model.addAttribute("collectionses", collectionsIterable);
        return "mycollections";
    }

    @RequestMapping(value = {"/mycollections"}, method= RequestMethod.POST)
    public String add(@RequestParam String name, @RequestParam String visitorName,
                      @RequestParam String filmName, @RequestParam String serialName,
                      Model model){
        Collections collections = new Collections(name, visitorName, filmName, serialName);
        collectionsRepo.save(collections);

        Iterable<Collections> collectionsIterable = collectionsRepo.findAll();
        model.addAttribute("collectionses", collectionsIterable);
        collectionsIterable = null;
        return "mycollections";
    }
}
