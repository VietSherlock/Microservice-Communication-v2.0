package com.vietsherlock.datastore.repository;

import com.vietsherlock.datastore.models.ProductOrder;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductOrderRepository extends MongoRepository<ProductOrder, String> {

    ProductOrder findAllById(String id);

}
