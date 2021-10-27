//package com.vietsherlock.productorder.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.vietsherlock.productorder.restclient.api.ProductOrderApi;
//import com.vietsherlock.productorder.restclient.model.*;
//import com.vietsherlock.productorder.restclient.model.OrderItemActionType;
//import com.vietsherlock.productorder.restclient.model.ProductOrderItem;
//import com.vietsherlock.productorder.restclient.model.RelatedChannel;
//import com.vietsherlock.productorder.server.models.*;
//import com.vietsherlock.productorder.server.models.CreateOrderResponse;
//import com.vietsherlock.productorder.server.models.ProductOrder;
//import com.vietsherlock.productorder.server.models.ProductOrderCreate;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.util.Arrays;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.hamcrest.Matchers.*;
//
//@WebMvcTest(ProductController.class)
//class ProductControllerTest {
//
//    Logger logger = LoggerFactory.getLogger(ProductControllerTest.class);
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Autowired
//    ObjectMapper mapper;
//
//    @MockBean
//    ProductOrderApi productOrderApi_Client;
//
//    com.vietsherlock.productorder.restclient.model.ProductOrder productOrder_client;
//    com.vietsherlock.productorder.restclient.model.ProductOrderCreate productOrderCreate_Client;
//    com.vietsherlock.productorder.restclient.model.CreateOrderResponse createOrderResponse_Client;
//
//    ProductControllerTest(){
//        /** create productOrder Client **/
//        ProductOrderItem orderItem_Client1 = new ProductOrderItem();
//        orderItem_Client1.setId("100");
//        orderItem_Client1.setAction(OrderItemActionType.ADD);
//
//        ProductOrderItem orderItem_Client2 = new ProductOrderItem();
//        orderItem_Client2.setId("100");
//        orderItem_Client2.setAction(OrderItemActionType.ADD);
//        productOrder_client = new com.vietsherlock.productorder.restclient.model.ProductOrder();
//        productOrder_client.setId("6177b6bb51e85a1fa53fb8d1");
//        productOrder_client.setHref("tmfAPI/productOrdering/productOrder/11.org");
//        productOrder_client.setExternalId("Telco01");
//        productOrder_client.setOrderItems(Arrays.asList(orderItem_Client1, orderItem_Client2));
//
//        /** create productOrderCreate  **/
//        RelatedChannel relatedChannel = new RelatedChannel();
//        relatedChannel.setId("1");
//        relatedChannel.setName(RelatedChannel.NameEnum.WEB);
//        relatedChannel.setRole("submitChannel");
//
//        productOrderCreate_Client = new com.vietsherlock.productorder.restclient.model.ProductOrderCreate();
//        productOrderCreate_Client.setChannel(relatedChannel);
//        productOrderCreate_Client.setOrderItems(Arrays.asList(orderItem_Client1, orderItem_Client2));
//        productOrderCreate_Client.setExternalId("5f7dac6cd65fb06f01ef23ac");
//        /** create createOrderResponse **/
//        createOrderResponse_Client = new com.vietsherlock.productorder.restclient.model.CreateOrderResponse();
//        createOrderResponse_Client.setOrderId(productOrderCreate_Client.getExternalId());
//        createOrderResponse_Client.setStatus("In Progress!");
//
//
//    }
//
//    @Test
//    void retrieveProductOrder_Success() throws Exception {
//        Mockito.when(productOrderApi_Client.retrieveProductOrder(productOrder_client.getId(), null))
//                .thenReturn(productOrder_client);
//
////        logger.info("id: " + productOrder_client.getId());
////        logger.info("productOrder: " + productOrder_client);
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("/productOrder/5f7dac6cd65fb06f01ef23ac")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", notNullValue()))
//                .andExpect(jsonPath("$.externalId", is("Telco01")))
//        ;
//
//    }
//
//    @Test
//    void createProductOrder_Success() throws Exception{
//        Mockito.when(productOrderApi_Client.createProductOrder(productOrderCreate_Client, false))
//                .thenReturn(createOrderResponse_Client);
//
//        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/productOrder")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(this.mapper.writeValueAsString(productOrderCreate_Client));
//
//        mockMvc.perform(mockRequest)
//                .andExpect(status().isAccepted())
//                .andExpect(jsonPath("$", notNullValue()))
//                .andExpect(jsonPath("$.status", is("IN PROGRESS")));
//
//    }
//}