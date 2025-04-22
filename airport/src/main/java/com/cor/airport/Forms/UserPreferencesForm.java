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

    public UserPreferencesForm() {
        // Default constructor
    }

    public UserPreferencesForm(String name, String username, String password, String email) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Overall_Preferences> getOverallPreferences(){
        return this.overallPreferences;
    }
    public void setOverallPreferences(ArrayList<Overall_Preferences> overall_Preferences){
        this.overallPreferences = overall_Preferences;
    }
    public ArrayList<Food_Preferences> getFoodPreferences(){
        return this.foodPreferences;
    }
    public void setFoodPreferences(ArrayList<Food_Preferences> food_Preferences){
        this.foodPreferences = food_Preferences;
    }
    public  ArrayList<Beverage_Preferences> getBeveragePreferences(){
        return this.beveragePreferences;
    }
    public void setBeveragePreferences(ArrayList<Beverage_Preferences> beverage_Preferences){
        this.beveragePreferences = beverage_Preferences;
    }
    public ArrayList<Shopping_Preferences> getShoppingPreferences(){
        return this.shoppingPreferences;
    }
    public void setShoppingPreferences(ArrayList<Shopping_Preferences> shopping_Preferences){
        this.shoppingPreferences = shopping_Preferences;
    }
    public ArrayList<Recreation_Preferences> getRecreationPreferences(){
        return this.recreationPreferences;
    }
    public void setRecreationPreferences(ArrayList<Recreation_Preferences> recreation_Preferences){
        this.recreationPreferences = recreation_Preferences;
    }
}
