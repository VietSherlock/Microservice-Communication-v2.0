package com.vietsherlock.datastore.service;

import com.vietsherlock.datastore.mapper.ProductOrderMapper;
import com.vietsherlock.datastore.models.ProductOrder;
import com.vietsherlock.datastore.repository.ProductOrderCreateRepository;
import com.vietsherlock.datastore.repository.ProductOrderRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DataStoreServiceImpTest {

    @InjectMocks
    DataStoreServiceImp dataStoreServiceImp;

    @Mock ProductOrderMapper productOrderMapper;
    @Mock ProductOrderRepository productOrderRepository;
    @Mock ProductOrderCreateRepository productOrderCreateRepository;

    @Test
    void canGetProductOrderByID() {
        //create mock data
        ProductOrder productOrder = new ProductOrder();



    }

    @Test
    @Disabled
    void addProductOrder() {
    }
}