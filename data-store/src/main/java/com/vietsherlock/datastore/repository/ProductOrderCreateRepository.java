package com.vietsherlock.datastore.repository;

import com.vietsherlock.datastore.models.ProductOrderCreate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderCreateRepository extends MongoRepository<ProductOrderCreate, String> {

}
