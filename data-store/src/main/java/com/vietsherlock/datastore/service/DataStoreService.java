package com.vietsherlock.datastore.service;

import com.vietsherlock.datastore.models.CreateOrderResponse;
import com.vietsherlock.datastore.models.ProductOrder;
import com.vietsherlock.datastore.models.ProductOrderCreate;

public interface DataStoreService {

    ProductOrder getProductOrderByID(String id);
    CreateOrderResponse addProductOrder(ProductOrderCreate productOrderCreate);

}
