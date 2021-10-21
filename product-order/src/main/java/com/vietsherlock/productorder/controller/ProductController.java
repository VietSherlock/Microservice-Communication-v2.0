package com.vietsherlock.productorder.controller;

import com.vietsherlock.productorder.mapper.ProductOrderMapper;
import com.vietsherlock.productorder.mapper.ProductOrderMapperImpl;
import com.vietsherlock.productorder.restclient.invoker.ApiClient;
import com.vietsherlock.productorder.server.api.ProductOrderApi;
import com.vietsherlock.productorder.server.models.CreateOrderResponse;
import com.vietsherlock.productorder.server.models.ProductOrder;
import com.vietsherlock.productorder.server.models.ProductOrderCreate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController implements ProductOrderApi {

    Logger logger = LoggerFactory.getLogger(ProductController.class);
    ProductOrderMapper productOrderMapper = new ProductOrderMapperImpl();
    ApiClient apiClient = new ApiClient();

    @Override
    public ResponseEntity<CreateOrderResponse> createProductOrder(ProductOrderCreate body, Boolean readyToProcess) {
        logger.info("createProductOrder POST method is called!");

//        apiClient.setBasePath("http://localhost:8081/productOrderingManagement/v2");
        apiClient.setBasePath("http://localhost:8081");
        com.vietsherlock.productorder.restclient.api.ProductOrderApi productOrderApi_Client
                = new com.vietsherlock.productorder.restclient.api.ProductOrderApi(apiClient);

        //mapper ProductOrderCreate server to client
        com.vietsherlock.productorder.restclient.model.ProductOrderCreate productOrderCreate_Client
                = productOrderMapper.productOrderCreateServerToClient(body);

        //create productOrderCreate and receive CreateOrderResponse client type
        com.vietsherlock.productorder.restclient.model.CreateOrderResponse createOrderResponse_Client
            = productOrderApi_Client.createProductOrder(productOrderCreate_Client, readyToProcess);
        logger.info("CreateOrderResponse response from data-store microservice! " + createOrderResponse_Client);

        return new ResponseEntity<>(
                productOrderMapper.createOrderResponseClientToServer(createOrderResponse_Client)
                , HttpStatus.ACCEPTED
        );

    }

    //@RequestMapping(value = "/productOrder/{id}", method = RequestMethod.GET)
    @Override
    public ResponseEntity<ProductOrder> retrieveProductOrder(String id, String fields) {

        logger.info("retrieveProductOrderById is called!");

        ProductOrder productOrder_Server = new ProductOrder();
        com.vietsherlock.productorder.restclient.model.ProductOrder productOrder_Client = new com.vietsherlock.productorder.restclient.model.ProductOrder();

//        apiClient.setBasePath("http://localhost:8081/productOrderingManagement/v2");
        apiClient.setBasePath("http://localhost:8081");
        com.vietsherlock.productorder.restclient.api.ProductOrderApi productOrderApi_Client
                = new com.vietsherlock.productorder.restclient.api.ProductOrderApi(apiClient);
        productOrder_Client = productOrderApi_Client.retrieveProductOrder(id, fields);

        logger.info("ProductOrder data get from data-store microservice with id = " + id + " : " + productOrder_Client);

        productOrder_Server = productOrderMapper.productOrderClientToServer(productOrder_Client);

        return new ResponseEntity<>(productOrder_Server, HttpStatus.OK);
    }
}
