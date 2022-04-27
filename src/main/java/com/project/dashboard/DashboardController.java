package com.project.dashboard;


import com.project.dashboard.models.CustomerData;
import com.project.dashboard.models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class DashboardController {

    @Autowired
    private MongoDBService mongoDBService;

    @RequestMapping("/")
    public String home(Model model) {
        return "dashboardTemplate";
    }

    @RequestMapping("/data/{item}")
    public String GetItemLocations(@PathVariable String item, Model model) {
        List<String> locations = mongoDBService.FindByItem(item);
        Location location = new Location();
        location.setItem(item);
        location.setLocations(locations);
        model.addAttribute("data", location);
        return "locationTemplate";
    }

    @RequestMapping("/data/{item}/{location}")
    public String GetSaleData(@PathVariable String item, @PathVariable String location, Model model) {
        CustomerData data = mongoDBService.findByItemAndLocation(item, location);
        data.setItem("Item : " + item);
        data.setLocation("Location : " + location);
        model.addAttribute("data", data);
        return "customerDataTemplate";
    }
}
