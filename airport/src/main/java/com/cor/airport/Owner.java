package com.cor.airport;

import java.util.HashSet;
import com.cor.airport.layout.Business;

public class Owner extends User{

    private HashSet<Business> businesses;
    private HashSet<Business> restaurants;
    private HashSet<Business> shops;

    public Owner(String name, String username, String password, String email){
        super(name, username, password, email);
        businesses = new HashSet<>();
        restaurants = new HashSet<>();
        shops = new HashSet<>();
    }

    public HashSet<Business> getBusinesses(){
        return businesses;
    }

    /**adds new business to set
     * input - business
     * checks if business already exists in set and adds if not
     * output - void
     * @throws IllegalArgumentException if business already exists
     */

    /**removes business from set
     * input - business
     * checks if business exists in set and removes if so
     * output - void
     * @throws IllegalArgumentException if business does not exist
     */

    /**checks if business is in set
     * input - business
     * output - boolean
     */
    public boolean checkBusiness(Business business){
        return businesses.contains(business);
    }

    /**add activity to promote business
     * inputs - business and name and type of activity
     * checks if business exists in set and adds activity if so
     * outputs - none, activity added to business
     * @throws IllegalArgumentException if business does not exist
     * @throws IllegalArgumentException if business already has activity
     */

    /**remove activity from business
     * inputs - none
     * checks if business exists in set and removes activity if so
     * outputs - none, activity removed from business
     * @throws IllegalArgumentException if business not in set
     * @throws IllegalArgumentException if activity is null
     */

    /**returns all businesses of type restaurant
     * input - none
     * output - set of businesses
     */
    public HashSet<Business> getRestaurants(){
        return restaurants;
    }

    /**returns all businesses of type shop
     * input - none
     * output - set of businesses
     */
    public HashSet<Business> getShops(){
        return shops;
    }
    
}
