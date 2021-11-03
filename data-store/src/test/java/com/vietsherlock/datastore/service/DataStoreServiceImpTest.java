package com.vietsherlock.datastore.service;

import com.vietsherlock.datastore.mapper.*;
import com.vietsherlock.datastore.models.*;
import com.vietsherlock.datastore.repository.ProductOrderCreateRepository;
import com.vietsherlock.datastore.repository.ProductOrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DataStoreServiceImpTest {

   @InjectMocks private DataStoreServiceImp dataStoreServiceImp;
   @Mock private ProductOrderCreateRepository productOrderCreateRepository;
   @Mock ProductOrderRepository productOrderRepository;
   @Mock ProductOrderMapper productOrderMapper;

    @Test
//    @Disabled
    void canGetProductOrderByID_Success() {
        //create mock data
        ProductOrderItem productOrderItem1 = new ProductOrderItem();
        productOrderItem1.setId(1);
        productOrderItem1.setAction(OrderItemActionType.ADD);

        ProductOrderItem productOrderItem2 = new ProductOrderItem();
        productOrderItem2.setId(2);
        productOrderItem2.setAction(OrderItemActionType.CHANGE);

        CurrentStatus currentStatus = new CurrentStatus();
        currentStatus.setName("Acknowledged");

        ProductOrder productOrder = new ProductOrder();
        String id = "617f5056be0109f451e0733f";
        productOrder.setId(id);
        productOrder.setOrderItems(Arrays.asList(productOrderItem1, productOrderItem2));
        productOrder.setCurrentStatus(currentStatus);

        ProductOrderDTO expectedDTO = productOrderMapper.productOrderToDTO(productOrder);

        //define behavior of Repository
        when(productOrderRepository.findAllById(id)).thenReturn(productOrder);

        ProductOrderDTO productOrderDTO = dataStoreServiceImp.getProductOrderByID(id);

        assertThat(expectedDTO).isEqualTo(productOrderDTO);

    }

    @Test
//    @Disabled
    void canAddProductOrder() {
        //given
        ProductOrderCreate productOrderCreate = new ProductOrderCreate();
        productOrderCreate.setExternalId("POC1");

        when(productOrderCreateRepository.save(productOrderCreate)).thenReturn(productOrderCreate);

        CreateOrderResponse createOrderResponse = dataStoreServiceImp.addProductOrder(productOrderCreate);

        assertThat(createOrderResponse.getOrderId()).isEqualTo(productOrderCreate.getExternalId());
        assertThat(createOrderResponse.getStatus()).isEqualTo("IN PROGRESS");

    }
}