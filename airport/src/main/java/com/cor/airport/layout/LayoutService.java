package com.cor.airport.layout;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Service;

import com.cor.airport.AirportController;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LayoutService {
    private final AirportController airportLayout;

    public LayoutService() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = getClass().getResourceAsStream("/resources/static/airport1.json");
        this.airportLayout = mapper.readValue(is, AirportController.class);
    }

    public AirportController getAirportController() {
        return airportLayout;
    }
}
