package com.vietsherlock.datastore.controller;

import com.vietsherlock.datastore.api.ProductOrderApi;
import com.vietsherlock.datastore.models.CreateOrderResponse;
import com.vietsherlock.datastore.models.ProductOrder;
import com.vietsherlock.datastore.models.ProductOrderCreate;
import com.vietsherlock.datastore.service.DataStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataStoreController implements ProductOrderApi {

    @Autowired
    DataStoreService dataStoreService;

    private static final Logger logger = LoggerFactory.getLogger(DataStoreController.class);

//    @RequestMapping(value = "/productOrder", method = RequestMethod.POST)
    @Override
    public ResponseEntity<CreateOrderResponse> createProductOrder(ProductOrderCreate body, Boolean readyToProcess) {

        logger.info("createProductOrder function in data-store microservice is called!");

        CreateOrderResponse createOrderResponse = dataStoreService.addProductOrder(body);
        logger.info("CreateOrderResponse is " + createOrderResponse);

        return new ResponseEntity<>(createOrderResponse, HttpStatus.OK);
    }

//    @RequestMapping(value = "/productOrder/{id}", method = RequestMethod.GET)
    @Override
    public ResponseEntity<ProductOrder> retrieveProductOrder(String id, String fields) {
        logger.info("DataStore controller is called!");
        return new ResponseEntity<>(dataStoreService.getProductOrderByID(id), HttpStatus.OK);
    }
}
