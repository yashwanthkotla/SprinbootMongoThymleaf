package com.project.dashboard.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
    public int  quantity;
    public double price;
    public String saleDate;
    public String email;
    public int age;
    public String gender;
    public String purchaseMethod;
}
