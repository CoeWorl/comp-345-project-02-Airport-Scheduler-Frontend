package com.cor.airport.layout;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/layout")
public class LayoutController {
    
    private final LayoutService layoutService;

    public LayoutController(LayoutService layoutService) {
        this.layoutService = layoutService;
    }

   // @GetMapping
    //public Airport getController() {
    //    return layoutService.getAirportLayout();
    //}


    @GetMapping("/api/layout-view")
    public String showLayout(Model model) {
        model.addAttribute("layout", layoutService.getAirportLayout());
        return "layout"; // layout.html
    }
}
