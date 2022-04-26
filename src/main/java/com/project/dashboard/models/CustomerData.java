package com.project.dashboard.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerData {
    public String item;
    public String location;
    public List<Sale> sales;
}
