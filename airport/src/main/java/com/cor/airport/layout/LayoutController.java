package com.cor.airport.layout;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.cor.airport.AirportController;

@RestController
@RequestMapping("/api/layout")
public class LayoutController {
    
    private final LayoutService layoutService;

    public LayoutController(LayoutService layoutService) {
        this.layoutService = layoutService;
    }

    @GetMapping
    public AirportController getController() {
        return layoutService.getAirportController();
    }
}
