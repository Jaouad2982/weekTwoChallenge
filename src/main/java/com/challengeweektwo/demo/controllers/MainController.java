package com.challengeweektwo.demo.controllers;


import com.challengeweektwo.demo.models.Robo;
import com.challengeweektwo.demo.repositories.RoboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    RoboRepository roboRepository;

    @GetMapping("/")
    public String getPage(Model model){
        String theMessage = "Welcome to my page";
        model.addAttribute("message" , theMessage);
        return "page";
    }

    @GetMapping("/addInfo")
    public String addInform(Model model ){
        model.addAttribute("newRobo" , new Robo());
        return "addInfo";
    }

    @PostMapping("/addInfo")
    public String showResult(@Valid @ModelAttribute("newRobo") Robo robo, BindingResult bindingResult){

        if(bindingResult.hasErrors())
        {
        return "addInfo";

        }
        roboRepository.save(robo);
        return "resultSearch";
    }

    @GetMapping("/display")
    public String displayList(Model model){

        Iterable<Robo> myList = roboRepository.findAll();
        model.addAttribute("resumeList" , myList);
        return "display";
    }
}
