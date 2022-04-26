package com.project.dashboard.mongo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Customer {
    private String email;
    private String gender;
    private int age;
    private int satisfaction;
}
