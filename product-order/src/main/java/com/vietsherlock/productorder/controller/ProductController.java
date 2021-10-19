package com.vietsherlock.productorder.controller;

import com.vietsherlock.productorder.mapper.ProductOrderMapper;
import com.vietsherlock.productorder.mapper.ProductOrderMapperImpl;
import com.vietsherlock.productorder.restclient.invoker.ApiClient;
//import com.vietsherlock.productorder.restclient.api.ProductOrderApi;
import com.vietsherlock.productorder.server.api.ProductOrderApi;
import com.vietsherlock.productorder.server.models.CreateOrderResponse;
import com.vietsherlock.productorder.server.models.ProductOrder;
import com.vietsherlock.productorder.server.models.ProductOrderCreate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController implements ProductOrderApi {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Override
    public ResponseEntity<CreateOrderResponse> createProductOrder(ProductOrderCreate body, Boolean readyToProcess) {

        logger.info("createProductOrder is called!");

        Api

        return null;
    }

//
    @Override
    public ResponseEntity<ProductOrder> retrieveProductOrder(String id, String fields) {

//        fields = "fields";

        logger.info("retrieveProductOrderById is called!");

        ProductOrder productOrder_Server = new ProductOrder();
        com.vietsherlock.productorder.restclient.model.ProductOrder productOrder_Client = new com.vietsherlock.productorder.restclient.model.ProductOrder();

        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath("http://localhost:8081");
        com.vietsherlock.productorder.restclient.api.ProductOrderApi productOrderApi_Client = new com.vietsherlock.productorder.restclient.api.ProductOrderApi(apiClient);
        productOrder_Client = productOrderApi_Client.retrieveProductOrder(id, fields);

        logger.info("ProductOrder data get from data-store microservice with id = " + id + " : " + productOrder_Client);

        ProductOrderMapper productOrderMapper = new ProductOrderMapperImpl();
        productOrder_Server = productOrderMapper.productOrderToProductOrder(productOrder_Client);

        return new ResponseEntity<>(productOrder_Server, HttpStatus.OK);
    }
}
