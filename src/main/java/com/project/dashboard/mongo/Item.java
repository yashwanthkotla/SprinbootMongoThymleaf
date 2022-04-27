package com.project.dashboard.mongo;


import lombok.Data;

@Data
public class Item {
    private String name;
    private int quantity;
    private double price;
}
