package com.vietsherlock.productorder.controller;

import com.vietsherlock.productorder.server.api.ProductOrderApi;
import com.vietsherlock.productorder.server.models.CreateOrderResponse;
import com.vietsherlock.productorder.server.models.ProductOrder;
import com.vietsherlock.productorder.server.models.ProductOrderCreate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController implements ProductOrderApi {
    @Override
    public ResponseEntity<CreateOrderResponse> createProductOrder(ProductOrderCreate body, Boolean readyToProcess) {
        return null;
    }

//
    @Override
    public ResponseEntity<ProductOrder> retrieveProductOrder(String id, String fields) {

        ProductOrder productOrder = new ProductOrder();
        productOrder.setId("1");
        productOrder.setDescription("This is get method result");

        return new ResponseEntity<>(productOrder, HttpStatus.OK);
    }
}
