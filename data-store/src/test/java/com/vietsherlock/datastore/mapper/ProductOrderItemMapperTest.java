//package com.vietsherlock.datastore.mapper;
//
//import com.vietsherlock.datastore.models.ProductOrderItem;
//import com.vietsherlock.datastore.models.ProductOrderItemDTO;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {ProductOrderItemMapperImpl.class})
//class ProductOrderItemMapperTest {
//
//    @Autowired
//    ProductOrderItemMapper productOrderItemMapper;
//
//    @Test
//    void productOItoDTO() {
//        //given
//        ProductOrderItem productOrderItem = new ProductOrderItem();
//        productOrderItem.setId(1);
//        ProductOrderItemDTO productOrderItemDTO = new ProductOrderItemDTO();
//        productOrderItemDTO.setId("1");
//
//        //when
//        ProductOrderItemDTO expected = productOrderItemMapper.productOItoDTO(productOrderItem);
//
//        //then
//        assertThat(expected).isEqualTo(productOrderItemDTO);
//    }
//}