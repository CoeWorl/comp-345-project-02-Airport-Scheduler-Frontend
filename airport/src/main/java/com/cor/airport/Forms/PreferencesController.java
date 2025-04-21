package com.cor.airport.Forms;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cor.airport.Passenger;
import com.cor.airport.User;




@Controller
@RequestMapping("/api/preferences")
public class PreferencesController {
    

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("form", new UserPreferencesForm(null, null, null, null));
        return "preferences-form";
    }
    
    @PostMapping
    public String handleFormSubmit(@ModelAttribute("form") UserPreferencesForm form, Model model) {
        ArrayList<User.Overall_Preferences> overallPrefs = form.getOverall_preferences();
        ArrayList<User.Food_Preferences> foodPrefs = form.getFood_preferences();
        ArrayList<User.Beverage_Preferences> bevPrefs = form.getBeverage_preferences();
        ArrayList<User.Shopping_Preferences> shopPrefs = form.getShopping_preferences();
        ArrayList<User.Recreation_Preferences> recPrefs = form.getRecreation_preferences();
        
        // Creating a subclass of User
        User user = new Passenger(form.getName(), form.getUsername(), form.getPassword(), form.getEmail());
        user.setPreferences(overallPrefs, foodPrefs, bevPrefs, shopPrefs, recPrefs);

        model.addAttribute("user", user);
        return "preferences-success";
    }
    
}
