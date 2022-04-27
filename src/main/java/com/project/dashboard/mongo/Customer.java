package com.project.dashboard.mongo;

import lombok.Data;

@Data
public class Customer {
    private String email;
    private String gender;
    private int age;
    private int satisfaction;
}
