package com.vietsherlock.datastore.service;

import com.vietsherlock.datastore.models.CreateOrderResponse;
import com.vietsherlock.datastore.models.ProductOrder;
import com.vietsherlock.datastore.models.ProductOrderCreate;
import com.vietsherlock.datastore.models.ProductOrderDTO;

public interface DataStoreService {

    ProductOrderDTO getProductOrderByID(String id);
    CreateOrderResponse addProductOrder(ProductOrderCreate productOrderCreate);

}
