package com.cor.airport.Forms;


import com.cor.airport.User;
import com.cor.airport.User.Beverage_Preferences;
import com.cor.airport.User.Food_Preferences;
import com.cor.airport.User.Overall_Preferences;
import com.cor.airport.User.Recreation_Preferences;
import com.cor.airport.User.Shopping_Preferences;

import java.util.ArrayList;

public class UserPreferencesForm {
    
    private String name;
    private String username;
    private String password;
    private String email;

    private ArrayList<User.Overall_Preferences> overallPreferences = new ArrayList<>();
    private ArrayList<User.Food_Preferences> foodPreferences = new ArrayList<>();
    private ArrayList<User.Beverage_Preferences> beveragePreferences = new ArrayList<>();
    private ArrayList<User.Shopping_Preferences> shoppingPreferences = new ArrayList<>();
    private ArrayList<User.Recreation_Preferences> recreationPreferences = new ArrayList<>();


    public UserPreferencesForm(String name, String username, String password, String email) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }

    public ArrayList<Overall_Preferences> getOverall_preferences(){
        return this.overallPreferences;
    }
    public ArrayList<Food_Preferences> getFood_preferences(){
        return this.foodPreferences;
    }
    public  ArrayList<Beverage_Preferences> getBeverage_preferences(){
        return this.beveragePreferences;
    }
    public ArrayList<Shopping_Preferences> getShopping_preferences(){
        return this.shoppingPreferences;
    }
    public ArrayList<Recreation_Preferences> getRecreation_preferences(){
        return this.recreationPreferences;
    }
}
