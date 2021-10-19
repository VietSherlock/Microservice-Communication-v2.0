package com.vietsherlock.productorder.mapper;

import com.vietsherlock.productorder.restclient.model.ProductOrderCreate;
import com.vietsherlock.productorder.server.models.CreateOrderResponse;
import com.vietsherlock.productorder.server.models.ProductOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProductOrderMapper {

    //Map ProductOrder Client to ProductOrder Server
    ProductOrder productOrderClientToServer(com.vietsherlock.productorder.restclient.model.ProductOrder productOrder);
    //Map ProductOrderCreate Server to ProductOrderCreate Client
    ProductOrderCreate productOrderCreateServerToClient(com.vietsherlock.productorder.server.models.ProductOrderCreate productOrderCreate);
    //Map CreateOrderResponse Client to Server
    CreateOrderResponse createOrderResponseClientToServer(com.vietsherlock.productorder.restclient.model.CreateOrderResponse createOrderResponse);

}
