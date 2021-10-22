package com.vietsherlock.datastore.service;

import com.vietsherlock.datastore.models.*;
import com.vietsherlock.datastore.repository.ProductOrderCreateRepository;
import com.vietsherlock.datastore.repository.ProductOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataStoreServiceImp implements DataStoreService{

    private static final Logger logger = LoggerFactory.getLogger(DataStoreServiceImp.class);
    private final ProductOrderRepository productOrderRepository;
    private final ProductOrderCreateRepository productOrderCreateRepository;

    @Autowired
    public DataStoreServiceImp(ProductOrderRepository productOrderRepository, ProductOrderCreateRepository productOrderCreateRepository) {
        this.productOrderRepository = productOrderRepository;
        this.productOrderCreateRepository = productOrderCreateRepository;
    }

    public ProductOrder getProductOrderByID(String id){
//        logger.info("The getProductOrderByID function has been called where the ProductOrder data by id is stored");
        return productOrderRepository.findAllById(id);
    }

    public CreateOrderResponse addProductOrder(ProductOrderCreate productOrderCreate){
        ProductOrderCreate productOrderCreated = productOrderCreateRepository.save(productOrderCreate);

        CreateOrderResponse createOrderResponse = new CreateOrderResponse();
        createOrderResponse.setOrderId("" + productOrderCreated.getExternalId());
        createOrderResponse.setStatus("IN PROGRESS");
        return createOrderResponse;
    }

}
