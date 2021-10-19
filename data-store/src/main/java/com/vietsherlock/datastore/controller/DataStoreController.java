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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataStoreController implements ProductOrderApi {

    @Autowired
    DataStoreService dataStoreService;

    private static final Logger logger = LoggerFactory.getLogger(DataStoreController.class);

//    @RequestMapping(value = "/productOrder",
//            produces = { "application/json", "application/json;charset=utf-8" },
//            consumes = { "application/json;charset=utf-8" },
//            method = RequestMethod.POST)
    @Override
    public ResponseEntity<CreateOrderResponse> createProductOrder(ProductOrderCreate body, Boolean readyToProcess) {

        dataStoreService.addProductOrder(body);

        return null;
    }

//    @RequestMapping(value = "/productOrder/{id}",
//            produces = { "application/json;charset=utf-8" },
//            method = RequestMethod.GET)
    @Override
    public ResponseEntity<ProductOrder> retrieveProductOrder(String id, String fields) {
        logger.info("DataStore controller is called!");
        return new ResponseEntity<>(dataStoreService.getProductOrderByID(id), HttpStatus.OK);
    }
}
