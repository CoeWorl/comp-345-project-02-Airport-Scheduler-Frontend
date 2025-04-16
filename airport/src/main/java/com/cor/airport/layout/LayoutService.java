package com.cor.airport.layout;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LayoutService {
    private final Airport airportLayout;

    public LayoutService() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("Trying to read airport.json...");

        try (InputStream is = getClass().getResourceAsStream("/airport.json")) {
            System.out.println("InputStream is null? " + (is == null));
            if (is == null) {
                throw new FileNotFoundException("airport.json not found.");
            }
            this.airportLayout = mapper.readValue(is, Airport.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load layout", e);
        }
    }

    public Airport getAirportLayout() {
        return airportLayout;
    }
}
