package com.cor.airport.Forms;

import java.util.ArrayList;
import java.util.List;

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
    
    private static final List<Passenger> storedPassengers = new ArrayList<>();


    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("form", new UserPreferencesForm());
        return "preferences-form";
    }
    
    @PostMapping
    public String handleFormSubmit(@ModelAttribute("form") UserPreferencesForm form, Model model) {
        ArrayList<User.Overall_Preferences> overallPrefs = form.getOverallPreferences();
        ArrayList<User.Food_Preferences> foodPrefs = form.getFoodPreferences();
        ArrayList<User.Beverage_Preferences> bevPrefs = form.getBeveragePreferences();
        ArrayList<User.Shopping_Preferences> shopPrefs = form.getShoppingPreferences();
        ArrayList<User.Recreation_Preferences> recPrefs = form.getRecreationPreferences();
        
        // Creating a subclass of User
        Passenger user = new Passenger(
            form.getName(),
            form.getUsername(),
            form.getPassword(),
            form.getEmail()    
        );

        user.setPreferences(overallPrefs, foodPrefs, bevPrefs, shopPrefs, recPrefs);

        storedPassengers.add(user);

        
        model.addAttribute("user", user);
        return "preferences-success";
    }
    
}
