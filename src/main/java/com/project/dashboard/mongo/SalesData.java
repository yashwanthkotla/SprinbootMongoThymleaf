package com.project.dashboard.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document("sales")
@Data
public class SalesData {

    @Id
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
