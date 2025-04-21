package com.cor.airport;

import java.io.IOException;
import java.time.Instant;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cor.airport.layout.Airport;
import com.cor.airport.layout.Gate;
import com.cor.airport.layout.Terminal;

@Controller
public class ScheduleViewController {
    
    @GetMapping("/schedule")
    public String showSchedule(Model model) throws IOException {
        String airportCode = "JFK";
        String terminalNumber = "1";
        String flightNumber = "AA1234";
        String gateUUID = "aa189ff2-5a5b-481f-9fb8-1937333e0dc9";

        Airport airport = Json.fromJsonFile("JFK/airport.json", Airport.class);
        Terminal terminal = Json.fromJsonFile("JFK/" + terminalNumber + ".json", Terminal.class);
        Flight flight = Json.fromJsonFile("JFK/Flights/testFlights.json", Flight.class);
        Gate gate = Json.fromJsonFile("JFK/POI/Gate/" + gateUUID + ".json", Gate.class);

        long deptTime = flight.getDeptTime();

        Schedule schedule = new Schedule(deptTime, airport, terminal, flight);
        schedule.randomSchedule(3);

        model.addAttribute("schedule", schedule);
        return "schedule"; // schedule.html
    }
}
