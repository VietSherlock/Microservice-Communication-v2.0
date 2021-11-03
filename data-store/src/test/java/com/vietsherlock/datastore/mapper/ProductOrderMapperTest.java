package com.vietsherlock.datastore.mapper;

import com.vietsherlock.datastore.models.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ProductOrderMapperTest {

    @InjectMocks ProductOrderMapper productOrderMapper = new ProductOrderMapperImpl();
    @Mock CurrentStatusMapper currentStatusMapper = new CurrentStatusMapperImpl();
    @Mock DateTimeMapper dateTimeMapper = new DateTimeMapper();
    @Mock ProductOrderItemMapperImpl productOrderItemMapper = new ProductOrderItemMapperImpl();

    @Test
    void canMappingProductOrderToDTO() {
        //given
        CurrentStatus currentStatus = new CurrentStatus();
        currentStatus.setVlocityStatus("Order Success!");
        currentStatus.setPreviousStates(Arrays.asList("CANCEL", "ORDERING", "PENDING"));
        currentStatus.setNextStates(Arrays.asList("ORDERED", "SHIPPING"));
        currentStatus.setName("Acknowledged");
        currentStatus.setDescription("Breve description del estado del procesamiento retornado");
        currentStatus.setDefaultPreviousStatus("PENDING");
        currentStatus.setDefaultNextStatus("SHIPPING");

        IssueTrack issueTrack1 = new IssueTrack();
        issueTrack1.setCurrentStatus("No Issue");
        issueTrack1.setRequestedStatus("Request Status");
        issueTrack1.setIssue("Missing Order");
        issueTrack1.issueDate(OffsetDateTime.now());

        IssueTrack issueTrack2 = new IssueTrack();
        issueTrack2.setCurrentStatus("No Issue2");
        issueTrack2.setRequestedStatus("Request Status2");
        issueTrack2.setIssue("Missing Order2");
        issueTrack2.issueDate(OffsetDateTime.now());

        ProductOfferingRef productOfferingRef = new ProductOfferingRef();
        productOfferingRef.setId("02i2F000003Rmzs");
        productOfferingRef.setCode("PO_MOVIL_PTIB5");
        productOfferingRef.setType(ProductOfferingRef.TypeEnum.PRODUCT);
        productOfferingRef.setBaseType(ProductOfferingRef.BaseTypeEnum.OFFERING);
        productOfferingRef.setPricebookEntryId("AHAIK");
        productOfferingRef.setProductHierarchyPath("KJKJKSJSKL");

        ProductOrderItem productOrderItem1 = new ProductOrderItem();
        productOrderItem1.setId(1);
        productOrderItem1.setAction(OrderItemActionType.ADD);
        productOrderItem1.setProductOffering(productOfferingRef);
        productOrderItem1.setDeliveryRef("OK");
        productOrderItem1.setBaseType("super-class");
        productOrderItem1.setSchemaLocation("https://www.tutorialspoint.com/");
        productOrderItem1.setType("entity name");

        ProductOrderItem productOrderItem2 = new ProductOrderItem();
        productOrderItem2.setId(2);
        productOrderItem2.setAction(OrderItemActionType.CHANGE);
        productOrderItem2.setProductOffering(productOfferingRef);
        productOrderItem2.setDeliveryRef("OKE");
        productOrderItem2.setBaseType("super-class");
        productOrderItem2.setSchemaLocation("https://www.tutorialspoint.com/");
        productOrderItem2.setType("entity name");

        ProductOrder productOrder = new ProductOrder();
        productOrder.setId("1");
        productOrder.setCurrentStatus(currentStatus);
        productOrder.setIssuesTracking(Arrays.asList(issueTrack1, issueTrack2));
        productOrder.setHref("https://www.tutorialspoint.com/");
        productOrder.setDescription("This is description");
        productOrder.setExternalId("HKAUI");
        productOrder.setCreatedDate("2017-May-02 23:35:05 +0530");
        productOrder.setLastModifiedDateEdited(OffsetDateTime.now());
        productOrder.setOrderItems(Arrays.asList(productOrderItem1, productOrderItem2));
        productOrder.setBaseType("super-class");
        productOrder.setSchemaLocation("schemaLocation");
        productOrder.setType("entity name");

        //when
        ProductOrderDTO expectedMapping = productOrderMapper.productOrderToDTO(productOrder);

        //then
        assertThat(expectedMapping.getId()).isEqualTo(productOrder.getId());
        assertThat(expectedMapping.getCurrentStatus())
                .isEqualTo(currentStatusMapper.currentStatusToDTO(productOrder.getCurrentStatus()));
        assertThat(expectedMapping.getIssuesTracking()).isEqualTo(productOrder.getIssuesTracking());
        assertThat(expectedMapping.getHref()).isEqualTo(productOrder.getHref());
        assertThat(expectedMapping.getDescription()).isEqualTo(productOrder.getDescription());
        assertThat(expectedMapping.getExternalId()).isEqualTo(productOrder.getExternalId());
        assertThat(expectedMapping.getCreatedDate())
                .isEqualTo(dateTimeMapper.toOffsetDateTime(productOrder.getCreatedDate()));
        assertThat(expectedMapping.getLastModifiedDate()).isEqualTo(productOrder.getLastModifiedDateEdited());
        assertThat(expectedMapping.getOrderItems().get(0))
                .isEqualTo(productOrderItemMapper.productOItoDTO(productOrder.getOrderItems().get(0)));
        assertThat(expectedMapping.getBaseType()).isEqualTo(productOrder.getBaseType());
        assertThat(expectedMapping.getType()).isEqualTo(productOrder.getType());

    }
}
