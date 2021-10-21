package com.vietsherlock.datastore.service;

import com.vietsherlock.datastore.models.CreateOrderResponse;
import com.vietsherlock.datastore.models.ProductOrder;
import com.vietsherlock.datastore.models.ProductOrderCreate;

import java.util.List;

public interface DataStoreService {

    List<ProductOrder> getAll();
    ProductOrder getProductOrderByID(String id);
    CreateOrderResponse addProductOrder(ProductOrderCreate productOrderCreate);

}
