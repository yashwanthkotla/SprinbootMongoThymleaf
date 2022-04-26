package com.project.dashboard.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SalesRepository extends MongoRepository<SalesData, String> {

    List<SalesData> findAll();
    @Query("{items: { $elemMatch: { name: '?0' } }}")
    List<SalesData> FindByItem(String item);

    @Query("{items: { $elemMatch: { name: '?0' } }, storeLocation: '?1'}")
    List<SalesData> findByItemAndLocation(String item, String location);

    public long count();

}
