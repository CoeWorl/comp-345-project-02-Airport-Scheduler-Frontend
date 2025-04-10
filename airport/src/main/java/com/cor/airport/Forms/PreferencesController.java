package com.cor.airport.Forms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class PreferencesController {
    

    @GetMapping("/preferences")
    public String showForm(Model model) {
        return "register";
    }
    
    @PostMapping("/preferences")
    public String submitForm(@ModelAttribute Preferences preferences, Model model) {
        //TODO: process POST request
        
        return "success";
    }
    
}
