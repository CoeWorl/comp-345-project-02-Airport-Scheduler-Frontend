package com.cor.airport.layout;

import com.cor.airport.Json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record Connection(int weight, POI dest) {
    public Connection(@JsonProperty("weight") int weight,
                      @JsonProperty("uuid") UUID uuid,
                      @JsonProperty("airportCode") String airportCode) {
        this(weight, createPOI(uuid, airportCode));
    }

    private static POI createPOI(UUID uuid, String airportCode) {
        try {
            return Json.jsonPOI(uuid, airportCode);
        } catch (Exception e) {
            System.err.println("Error creating POI: " + e);
            return null;
        }
    }

    public int getWeight() {
        return weight;
    }

    public POI getDest() {
        return dest;
    }

    @Override
    public String toString() {
        return String.format("Connection{weight=%d, destUUID=%s}", weight, this.getDest().getUuid());
    }
}