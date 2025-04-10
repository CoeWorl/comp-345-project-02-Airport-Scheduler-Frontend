package com.cor.airport;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api")
public class Json {
    private static final String FILE_PATH = "src/main/resources/static/1.json";

    public static String toJsonString(Object objectToSerialize) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        return mapper.writeValueAsString( objectToSerialize);
    }

    public static void toJsonFile(String filename, Object objectToSerialize) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(new File(filename), objectToSerialize);
    }

    public static <T> T fromJsonFile(String filename, Class<? extends T> classToBeCreated) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return  mapper.readValue(new File(filename), classToBeCreated);
    }


    @GetMapping("/getAirport")
    public ResponseEntity<String> getJsonAsString() {
    try {
        // Read the entire JSON file as a raw string
        String json = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(FILE_PATH)));
        return ResponseEntity.ok(json);
    } catch (IOException e) {
        return ResponseEntity.status(500).body("Error reading JSON file");
    }
}

    @PostMapping("/airport")
    public ResponseEntity<String> fetchJson(@RequestBody Map<String, Object> json) {        
        try {
            String jsonString = toJsonString(json);
            System.out.println(jsonString);
        }
        catch (JsonProcessingException e){
            return ResponseEntity.status(500).body(null);
        }
        return ResponseEntity.ok("JSON received successfully");        
    }
}