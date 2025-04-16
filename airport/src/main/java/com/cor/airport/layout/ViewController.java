package com.cor.airport.layout;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    
    private final LayoutService layoutService;

    public ViewController(LayoutService layoutService) {
        this.layoutService = layoutService;
    }

    @GetMapping("/layout-view")
    public String showLayout(Model model) {
        model.addAttribute("layout", layoutService.getAirportLayout());
        return "layout"; // layout.html
    }
}
