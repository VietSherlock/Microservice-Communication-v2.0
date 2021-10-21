package com.vietsherlock.datastore.repository;

import com.vietsherlock.datastore.models.ProductOrderCreate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductOrderCreateRepository extends MongoRepository<ProductOrderCreate, String> {

}
