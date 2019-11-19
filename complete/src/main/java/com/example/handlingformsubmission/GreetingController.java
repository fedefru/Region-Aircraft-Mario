package com.example.handlingformsubmission;

import com.example.handlingformsubmission.model.Airline;
import com.example.handlingformsubmission.model.Arrives;
import com.example.handlingformsubmission.model.Paises;
import com.example.handlingformsubmission.service.ServiceApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingController {

    @Autowired
    ServiceApp serviceApp;

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }


    @GetMapping("/airlines")
    public String airlinesForm(Model model) {
        model.addAttribute("airlines", serviceApp.getAirlines().iterator());
        return "airlines";
    }

    @GetMapping("/seats")
    public String airlinesSeats(Model model) {
        model.addAttribute("airline", new Airline());
        return "airlineForm";
    }

    @PostMapping("/seat")
    public String seatSubmit(@ModelAttribute Airline airline) {
        airline.setEconomySeat(serviceApp.getEconomySeatsFromAirlines(airline.getAirlineNameShort(),airline.getAirlineNameLong()));
        return "airlineFormResult";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting) {
        serviceApp.getAirlines();
        return "result";
    }
    
    @GetMapping("/region")
    public String region(Model model) {
        model.addAttribute("paises", new Paises());
        return "region";
    }
    
    @GetMapping("/mandoArrive")
    public String arrive(Model model) {
        model.addAttribute("arrive", new Arrives());
        return "mandoArrive";
    }
    
    @PostMapping("/resultArrive")
    public String arrive(@ModelAttribute Arrives arrive, Model modelo) {
        modelo.addAttribute("listado", serviceApp.getArrives(arrive.getValor(),arrive.getValor1()));
        return "resultArrive";
    }
    
    @PostMapping("/paises")
    public String region(@ModelAttribute Paises paises, Model modelo) {
        modelo.addAttribute("listado", serviceApp.getContinentes(paises.getRegion()));
        return "regionResult";
    }


    

}
