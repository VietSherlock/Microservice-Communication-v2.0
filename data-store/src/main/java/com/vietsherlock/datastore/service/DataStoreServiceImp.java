package com.vietsherlock.datastore.service;

import com.vietsherlock.datastore.mapper.ProductOrderMapper;
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
    private final ProductOrderMapper productOrderMapper;

    @Autowired
    public DataStoreServiceImp(ProductOrderRepository productOrderRepository, ProductOrderCreateRepository productOrderCreateRepository, ProductOrderMapper productOrderMapper) {
        this.productOrderRepository = productOrderRepository;
        this.productOrderCreateRepository = productOrderCreateRepository;
        this.productOrderMapper = productOrderMapper;
    }

    public ProductOrderDTO getProductOrderByID(String id){
//        logger.info("Name field, type String in CurrentStatus: " + productOrderRepository.findAllById(id).getCurrentStatus().getName());
//        logger.info("=========Mapping==========>");
//        logger.info("Name field, type Enum in CurrentStatusDTO: "
//                + productOrderMapper.productOrderToDTO(productOrderRepository.findAllById(id)).getCurrentStatus().getName());

        ProductOrderDTO productOrderDTO
                = productOrderMapper.productOrderToDTO(productOrderRepository.findAllById(id));

        logger.info("name field in CurrentStatus: " + productOrderRepository.findAllById(id).getCurrentStatus().getName());
        return productOrderDTO;
    }

    public CreateOrderResponse addProductOrder(ProductOrderCreate productOrderCreate){
        ProductOrderCreate productOrderCreated = productOrderCreateRepository.save(productOrderCreate);

        CreateOrderResponse createOrderResponse = new CreateOrderResponse();
        createOrderResponse.setOrderId("" + productOrderCreated.getExternalId());
        createOrderResponse.setStatus("IN PROGRESS");
        return createOrderResponse;
    }

}
