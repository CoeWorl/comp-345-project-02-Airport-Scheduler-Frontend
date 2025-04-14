package com.cor.airport;

import static org.junit.Assert.assertThrows;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.Test;

import com.cor.airport.layout.Business;
import com.cor.airport.layout.Terminal;

public class userTest {
    
    @Test
    public void userConstructorTest() {
        ArrayList<User> users = new ArrayList<>();
        assertTrue(users.isEmpty());
        Passenger rebecca = new Passenger("Rebecca", "redson", "123", "redson@ithaca.edu");
        users.add(rebecca);
        assertEquals(users.size(), 1);
        assertEquals(rebecca.getName(), "Rebecca");
        assertEquals(rebecca.getUsername(), "redson");
        assertEquals(rebecca.getEmail(), "redson@ithaca.edu");
        assertTrue(rebecca.checkCredentials("rje158", "123"));
        rebecca.updatePassword("123", "456");
        assertTrue(rebecca.checkCredentials("rje158", "456"));
        assertFalse(rebecca.checkCredentials("rje158", "123"));
        assertThrows(IllegalArgumentException.class, () -> rebecca.updatePassword("123", "333"));
        rebecca.updateEmail("rje158@gmail.com");
        assertEquals(rebecca.getEmail(), "rje158@gmail.com");
        rebecca.updateUsername("rje158");
        assertEquals(rebecca.getUsername(), "rje158");
        rebecca.updateName("Becca");
        assertEquals(rebecca.getName(), "Becca");
        Owner noah = new Owner("Noah", "noed", "789", "no@gmail.com");
        users.add(noah);
        assertEquals(users.size(), 2);
        assertEquals(noah.getName(), "Noah");
        assertEquals(noah.getUsername(), "noed");
        assertEquals(noah.getEmail(), "no@gmail.com");
        assertTrue(noah.checkCredentials("noed", "789"));
        Passenger lindsay = new Passenger("Lindsay", "linds", "900", "linds@gmail.com");
        users.add(lindsay);
        assertEquals(users.size(), 3);
        assertEquals(lindsay.getName(), "Lindsay");
        assertEquals(lindsay.getUsername(), "linds");
        assertEquals(lindsay.getEmail(), "linds@gmail.com");
        assertTrue(lindsay.checkCredentials("linds", "900"));
        assertThrows(IllegalArgumentException.class, () -> lindsay.updateEmail("lindsay"));
    }

    @Test
    public void passengerTest(){
        Passenger rebecca = new Passenger("Rebecca", "redson", "123", "redson@ithaca.edu");
        assertThrows(IllegalArgumentException.class, () -> rebecca.addFlight("ab23"));
        assertThrows(IllegalArgumentException.class, () -> rebecca.removeFlight("ab23"));
        assertThrows(IllegalArgumentException.class, () -> rebecca.createSchedule("ab23"));
        assertThrows(IllegalArgumentException.class, () -> rebecca.randomSchedule("ab23"));
        assertThrows(IllegalArgumentException.class, () -> rebecca.getSchedule("ab23"));
        assertFalse(rebecca.checkFlight("ab23"));
        HashMap<Flight, Schedule> flightPlans = rebecca.getFlightPlans();
        assertTrue(flightPlans.isEmpty());
        //need flight and schedule classes and flight database/json to test further
        //add flight
        assertEquals(rebecca.getFlightPlans().size(), 1);
        //remove flight
        assertTrue(rebecca.getFlightPlans().isEmpty());
        //add flight
        //add flight
        assertEquals(rebecca.getFlightPlans().size(), 2);
        //create schedule for 1 flight
        //get schedule for that flight
        //create random schedule for other flight
        //get schedule for that flight
        //create new schedule
        //update schedule for flight 1 with new schedule
        //get schedule for flight 1
        //remove flight
        assertEquals(rebecca.getFlightPlans().size(), 1);
        //remove flight
        assertTrue(rebecca.getFlightPlans().isEmpty());
    }

    /*** 
    @Test
    public void ownerTest(){
        Owner noah = new Owner("Noah", "noed", "789", "no@gmail.com");
        HashSet<Business> businesses = noah.getBusinesses();
        assertTrue(businesses.isEmpty());
        Business business = new Business("restaurant", new Terminal("terminal 1"), "restaurant", "9am-3pm");
        assertThrows(IllegalArgumentException.class, () -> noah.removeBusiness(business));
        assertFalse(noah.checkBusiness(business));
        noah.addBusiness(business);
        assertTrue(noah.checkBusiness(business));
        assertEquals(noah.getBusinesses().size(), 1);
        assertEquals(noah.getRestaurants().size(), 1);
        assertTrue(noah.getShops().isEmpty());
        Business business2 = new Business("shop", new Terminal("terminal 1"), "shop", "9am-6pm");
        assertThrows(IllegalArgumentException.class, () -> noah.addActivity(business2, "sale", "sale"));
        noah.addBusiness(business2);
        assertEquals(noah.getBusinesses().size(), 2);
        assertEquals(noah.getShops().size(), 1);
        assertThrows(IllegalArgumentException.class, () -> noah.addBusiness(business));
        noah.addActivity(business2, "sale", "sale");
        assertTrue(business2.hasActivity());
        assertThrows(IllegalArgumentException.class, () -> noah.addActivity(business2, "super sale", "sale"));
        noah.removeActivity(business2);
        assertFalse(business2.hasActivity());
        assertThrows(IllegalArgumentException.class, () -> noah.removeActivity(business));
        noah.removeBusiness(business);
        assertEquals(noah.getBusinesses().size(), 1);
        assertTrue(noah.getRestaurants().isEmpty());
        assertEquals(noah.getShops().size(), 1);
        noah.removeBusiness(business2);
        assertTrue(noah.getBusinesses().isEmpty());
        assertTrue(noah.getShops().isEmpty());
        assertTrue(noah.getRestaurants().isEmpty());
    }
    */

    @Test
    void validEmailTest(){
        // valid email address
        assertTrue(User.validEmail("a@b.com"));   // Equivalence Class: valid email, Border case: No, valid format

        // empty string
        assertFalse(User.validEmail(""));         // Equivalence Class: invalid email (empty), Border case: Yes

        // invalid email, starts with invalid character
        assertFalse(User.validEmail("_a@gmail.com"));  // Equivalence Class: invalid email (starting with underscore), Border case: No

        // invalid email, domain missing after '@'
        assertFalse(User.validEmail("a@.com"));      // Equivalence Class: invalid email (missing domain), Border case: Yes

        // invalid email, missing '@' symbol
        assertFalse(User.validEmail("a@gmail"));     // Equivalence Class: invalid email (missing '@' symbol), Border case: No

        // valid email address from a university domain
        assertTrue(User.validEmail("redson@ithaca.edu"));  // Equivalence Class: valid email, Border case: No, valid format

        // invalid email, missing local part before '@'
        assertFalse(User.validEmail("@gmail.com"));  // Equivalence Class: invalid email (missing local part), Border case: Yes

        // invalid email, contains space
        assertFalse(User.validEmail("a b@gmail.com"));  // Equivalence Class: invalid email (contains space), Border case: No

        // invalid email, missing '@'
        assertFalse(User.validEmail("agmail.com"));  // Equivalence Class: invalid email (missing '@'), Border case: Yes
        
    }

}
