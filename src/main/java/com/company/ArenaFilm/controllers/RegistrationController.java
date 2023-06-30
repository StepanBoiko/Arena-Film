package com.company.ArenaFilm.controllers;

import com.company.ArenaFilm.models.Films;
import com.company.ArenaFilm.models.Role;
import com.company.ArenaFilm.models.User;
import com.company.ArenaFilm.repos.UserRepo;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @RequestMapping (value = {"/registration"}, method= RequestMethod.POST)
    public String addUser(User user, Model model){
        User userFromDb = userRepo.findByUsername(user.getUsername());

//        if (userFromDb != null){
//            model.addAttribute("message", "User exist!");
//            return "registration";
//        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        return "redirect:/login";
    }
}
