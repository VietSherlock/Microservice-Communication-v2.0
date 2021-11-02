package com.vietsherlock.datastore.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vietsherlock.datastore.models.*;
import com.vietsherlock.datastore.service.DataStoreServiceImp;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
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

    ProductOrderDTO productOrderDTO;
    ProductOrderCreate productOrderCreate;
    CreateOrderResponse createOrderResponse;

    DataStoreControllerTest(){
        /** create productOrderDTO **/
        ProductOrderItemDTO orderItem1 = new ProductOrderItemDTO();
        orderItem1.setId("101");
        orderItem1.setAction(OrderItemActionType.ADD);

        ProductOrderItemDTO orderItem2 = new ProductOrderItemDTO();
        orderItem2.setId("102");
        orderItem2.setAction(OrderItemActionType.CHANGE);

        productOrderDTO = new ProductOrderDTO();
        productOrderDTO.setId("1");
        productOrderDTO.setHref("tmfAPI/productOrdering/productOrder/11.org");
        productOrderDTO.setExternalId("Telco01");
        productOrderDTO.setOrderItems(Arrays.asList(orderItem1, orderItem2));
        /** create productOrderCreate  **/
        RelatedChannel relatedChannel = new RelatedChannel();
        relatedChannel.setId("1");
        relatedChannel.setName(RelatedChannel.NameEnum.WEB);
        relatedChannel.setRole("submitChannel");

        ProductOrderItem productOrderItem1 = new ProductOrderItem();
        productOrderItem1.setId(101);
        productOrderItem1.setAction(OrderItemActionType.ADD);

        ProductOrderItem productOrderItem2 = new ProductOrderItem();
        productOrderItem2.setId(102);
        productOrderItem2.setAction(OrderItemActionType.CHANGE);

        productOrderCreate = new ProductOrderCreate();
        productOrderCreate.setChannel(relatedChannel);
        productOrderCreate.setOrderItems(Arrays.asList(productOrderItem1, productOrderItem2));
        productOrderCreate.setExternalId("5f7dac6cd65fb06f01ef23ac");
        /** create createOrderResponse **/
        createOrderResponse = new CreateOrderResponse();
        createOrderResponse.setOrderId(productOrderCreate.getExternalId());
        createOrderResponse.setStatus("IN PROGRESS");

    }

    @Test
    void retrieveProductOrderById_success() throws Exception{
        Mockito.when(dataStoreServiceImp.getProductOrderByID(productOrderDTO.getId()))
                .thenReturn(productOrderDTO);

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
       Mockito.when(dataStoreServiceImp.addProductOrder(productOrderCreate)).thenReturn(createOrderResponse);

       MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/productOrder")
               .contentType(MediaType.APPLICATION_JSON)
               .accept(MediaType.APPLICATION_JSON)
               .content(this.mapper.writeValueAsString(productOrderCreate));

       mockMvc.perform(mockRequest)
               .andExpect(status().isCreated())
               .andExpect(jsonPath("$", notNullValue()))
               .andExpect(jsonPath("$.status", is("IN PROGRESS")));
    }
}