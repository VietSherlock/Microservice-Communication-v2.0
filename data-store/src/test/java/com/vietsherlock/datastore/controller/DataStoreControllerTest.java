package com.vietsherlock.datastore.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vietsherlock.datastore.models.OrderItemActionType;
import com.vietsherlock.datastore.models.ProductOrder;
import com.vietsherlock.datastore.models.ProductOrderItem;
import com.vietsherlock.datastore.service.DataStoreServiceImp;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;


@WebMvcTest(DataStoreController.class)

class DataStoreControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    DataStoreServiceImp dataStoreServiceImp;


    ProductOrder productOrder;

    DataStoreControllerTest(){
        ProductOrderItem orderItem1 = new ProductOrderItem();
        orderItem1.setId("100");
        orderItem1.setAction(OrderItemActionType.ADD);

        ProductOrderItem orderItem2 = new ProductOrderItem();
        orderItem2.setId("100");
        orderItem2.setAction(OrderItemActionType.ADD);

        productOrder = new ProductOrder();
        productOrder.setId("1");
        productOrder.setHref("tmfAPI/productOrdering/productOrder/11.org");
        productOrder.setExternalId("Telco01");
        productOrder.setOrderItems(Arrays.asList(orderItem1, orderItem2));
    }

    @Test
    void retrieveProductOrderById_success() throws Exception{
        Mockito.when(dataStoreServiceImp.getProductOrderByID(productOrder.getId())).thenReturn(productOrder);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/productOrder/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.externalId", is("Telco01")))
        ;
    }

    @Test
    void createProductOrder_success() throws Exception{

    }
}