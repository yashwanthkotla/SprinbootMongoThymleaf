package com.project.dashboard.mongo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SalesData {

    private String id;
    private Date saleDate;
    private List<Item> items;
    private String storeLocation;
    private Customer customer;
    private boolean couponUsed;
    private String purchaseMethod;

    public SalesData() {
        super();
    }
}
