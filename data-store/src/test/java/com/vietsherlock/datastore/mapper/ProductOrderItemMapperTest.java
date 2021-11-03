package com.vietsherlock.datastore.mapper;

import com.vietsherlock.datastore.models.OrderItemActionType;
import com.vietsherlock.datastore.models.ProductOfferingRef;
import com.vietsherlock.datastore.models.ProductOrderItem;
import com.vietsherlock.datastore.models.ProductOrderItemDTO;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
class ProductOrderItemMapperTest {

    ProductOrderItemMapper productOrderItemMapper = new ProductOrderItemMapperImpl();

    @Test
    void canMappingFromProductOItoDTO() {
        //given
        ProductOfferingRef productOfferingRef = new ProductOfferingRef();
        productOfferingRef.setId("02i2F000003Rmzs");
        productOfferingRef.setCode("PO_MOVIL_PTIB5");
        productOfferingRef.setType(ProductOfferingRef.TypeEnum.PRODUCT);
        productOfferingRef.setBaseType(ProductOfferingRef.BaseTypeEnum.OFFERING);
        productOfferingRef.setPricebookEntryId("AHAIK");
        productOfferingRef.setProductHierarchyPath("KJKJKSJSKL");

        ProductOrderItem productOrderItem = new ProductOrderItem();
        productOrderItem.setId(1);
        productOrderItem.setAction(OrderItemActionType.ADD);
        productOrderItem.setProductOffering(productOfferingRef);
        productOrderItem.setDeliveryRef("OK");
        productOrderItem.setBaseType("super-class");
        productOrderItem.setSchemaLocation("https://www.tutorialspoint.com/");
        productOrderItem.setType("entity name");

        //when
        ProductOrderItemDTO expectedMapping = productOrderItemMapper.productOItoDTO(productOrderItem);

        //then
        assertThat(expectedMapping.getId()).isEqualTo(String.valueOf(productOrderItem.getId()));
        assertThat(expectedMapping.getAction()).isEqualTo(OrderItemActionType.ADD);
        assertThat(expectedMapping.getProductOffering()).isEqualTo(productOfferingRef);
        assertThat(expectedMapping.getDeliveryRef()).isEqualTo(productOrderItem.getDeliveryRef());
        assertThat(expectedMapping.getBaseType()).isEqualTo(productOrderItem.getBaseType());
        assertThat(expectedMapping.getSchemaLocation()).isEqualTo(productOrderItem.getSchemaLocation());
        assertThat(expectedMapping.getType()).isEqualTo(productOrderItem.getType());

    }
}