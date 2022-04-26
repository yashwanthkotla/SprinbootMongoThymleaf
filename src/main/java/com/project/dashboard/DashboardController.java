package com.project.dashboard;


import com.project.dashboard.models.CustomerData;
import com.project.dashboard.models.Location;
import com.project.dashboard.models.Sale;
import com.project.dashboard.mongo.Item;
import com.project.dashboard.mongo.SalesData;
import com.project.dashboard.mongo.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class DashboardController {

    @Autowired
    private SalesRepository salesRepository;

    @RequestMapping("/")
    public String home(Model model) {
        return "dashboardTemplate";
    }


    @RequestMapping("/data/{item}")
    public String GetItemLocations(@PathVariable String item, Model model) {
        List<SalesData> sales = salesRepository.FindByItem(item);
        Set<String> locations = new HashSet<>(0);
        for (SalesData data : sales) {
            locations.add(data.getStoreLocation());
        }
        Location location = new Location();
        location.setItem(item);
        location.setLocations(locations.stream().collect(Collectors.toList()));
        model.addAttribute("data", location);
        return "locationTemplate";
    }

    @RequestMapping("/data/{item}/{location}")
    public String GetSaleData(@PathVariable String item, @PathVariable String location, Model model) {
        List<SalesData> sales = salesRepository.findByItemAndLocation(item, location);
        CustomerData data = new CustomerData();
        data.setItem("Item : " + item);
        data.setLocation("Location : " + location);
        data.setSales(convertToDTOs(sales, item));
        model.addAttribute("data", data);
        return "customerDataTemplate";
    }

    private List<Sale> convertToDTOs(List<SalesData> records, String itemName) {
        List<Sale> data = new ArrayList<>();
        int quantity = 0;
        double price = 0;
        for (SalesData record : records) {
            quantity = 0;
            price = 0;
            Sale sale = new Sale();
            sale.setSaleDate(convertDate(record.getSaleDate()));
            sale.setEmail(record.getCustomer().getEmail());
            sale.setAge(record.getCustomer().getAge());
            sale.setGender(record.getCustomer().getGender());
            sale.setPurchaseMethod(record.getPurchaseMethod());
            for (Item item : record.getItems()) {
                if (item.getName().equalsIgnoreCase(itemName)) {
                    quantity = quantity + item.getQuantity();
                    price = price + item.getPrice();
                }
            }
            sale.setQuantity(quantity);
            sale.setPrice(price);
            data.add(sale);
        }
        return data;
    }

    private String convertDate(Date date){
        SimpleDateFormat dateFormat= new SimpleDateFormat("dd-MMM-yyyy");
        return dateFormat.format(date);
    }
}
