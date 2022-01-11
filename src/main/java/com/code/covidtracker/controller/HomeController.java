package com.code.covidtracker.controller;

import com.code.covidtracker.models.LocationStats;
import com.code.covidtracker.services.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CovidDataService covidDataService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String home(Model model){
        List<LocationStats> allStats = covidDataService.getAllStats();
        int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestCovidCases()).sum();
        int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportedCases", String.format("%,d",totalReportedCases));
        model.addAttribute("totalNewCases", String.format("%,d",totalNewCases));
        return "home";
    }

}
