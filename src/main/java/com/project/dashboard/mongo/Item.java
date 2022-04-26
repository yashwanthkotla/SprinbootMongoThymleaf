package com.project.dashboard.mongo;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Item {
    private String name;
    private int quantity;
    private double price;
}
