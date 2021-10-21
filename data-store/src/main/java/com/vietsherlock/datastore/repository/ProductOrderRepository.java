package com.vietsherlock.datastore.repository;

import com.vietsherlock.datastore.models.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductOrderRepository extends MongoRepository<ProductOrder, String> {

//    ProductOrder findById(String id);
    ProductOrder findAllById(String id);
}
