package com.project.dashboard;

import com.mongodb.MongoClient;
import com.mongodb.client.*;
import com.project.dashboard.models.CustomerData;
import com.project.dashboard.models.Sale;
import com.project.dashboard.mongo.Item;
import com.project.dashboard.mongo.SalesData;
import org.bson.Document;
import org.bson.types.Decimal128;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MongoDBService {

    private MongoCollection<Document>  collection;

    public MongoDBService() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        System.out.println("Connected to the database successfully");
        MongoDatabase database = mongoClient.getDatabase("sales_data");
        this.collection = database.getCollection("sales");
    }

    public List<String> FindByItem(String item) {
        ArrayList<Document> data = collection.find(new Document("items", new Document("$elemMatch", new Document("name", item)))).into(new ArrayList<Document>());
        Set<String> locations = new HashSet<>();
        for (Document document : data) {
            locations.add((String) document.get("storeLocation"));
        }
        return new ArrayList<>(locations);
    }

    public CustomerData findByItemAndLocation(String item, String location) {
        ArrayList<Document> data = collection.find(new Document("items",
                        new Document("$elemMatch", new Document("name", item))).append("storeLocation", location))
                        .into(new ArrayList<>());
        int quantity = 0;
        double price = 0;
        List<Sale> salesData = new ArrayList<>();
        for (Document document : data) {
            quantity = 0;
            price = 0;
            Sale sale = new Sale();
            sale.setSaleDate(convertDate((Date) document.get("saleDate")));
            sale.setEmail((String) ((Document) document.get("customer")).get("email"));
            sale.setAge((Integer) ((Document) document.get("customer")).get("age"));
            sale.setGender((String) ((Document) document.get("customer")).get("gender"));
            sale.setPurchaseMethod((String) document.get("purchaseMethod"));
            List<Document> items = ((List<Document>) document.get("items"));
            for (Document i : items) {
                if (i.get("name").equals(item)) {
                    quantity = quantity + (Integer) i.get("quantity");
                    price = price + ((Decimal128) i.get("price")).doubleValue();
                }
            }
            sale.setQuantity(quantity);
            sale.setPrice(price);
            salesData.add(sale);
        }
        CustomerData c3 = new CustomerData();
        c3.setSales(salesData);
        return c3;
    }

    private String convertDate(Date date){
        SimpleDateFormat dateFormat= new SimpleDateFormat("dd-MMM-yyyy");
        return dateFormat.format(date);
    }
}
