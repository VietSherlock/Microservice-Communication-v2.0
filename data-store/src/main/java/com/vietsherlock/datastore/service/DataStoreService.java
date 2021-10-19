package com.vietsherlock.datastore.service;

import com.vietsherlock.datastore.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DataStoreService {

    private static final Logger logger = LoggerFactory.getLogger(DataStoreService.class);

    List<ProductOrder> productOrderList = new ArrayList<>();
    List<ProductOrderCreate> productOrderCreates = new ArrayList<>();
    CreateOrderResponse createOrderResponse = new CreateOrderResponse();

    public List<ProductOrder> getAll(){

        ProductOrder productOrder1 = new ProductOrder();

        CurrentStatus currentStatus1 = new CurrentStatus();
        currentStatus1.setVlocityStatus("Order Success!");
        currentStatus1.setName(CurrentStatus.NameEnum.COMPLETED);
        currentStatus1.setDefaultNextStatus("COMPLETE");
        currentStatus1.setDefaultPreviousStatus("PENDING");

        List<IssueTrack> issueTrackList1 = new ArrayList<>();

        IssueTrack issueTrack1 = new IssueTrack();
        issueTrack1.setCurrentStatus("PENDING");
        issueTrack1.setRequestedStatus("PASS");
        issueTrack1.setIssue("GOOD");
        issueTrack1.setIssueDate(OffsetDateTime.now());
        issueTrackList1.add(issueTrack1);

        IssueTrack issueTrack2 = new IssueTrack();
        issueTrack2.setCurrentStatus("COMPLETE");
        issueTrack2.setRequestedStatus("PASS");
        issueTrack2.setIssue("GOOD");
        issueTrack2.setIssueDate(OffsetDateTime.now());
        issueTrackList1.add(issueTrack2);

        List<ProductOrderItem> productOrderItems = new ArrayList<>();
        ProductOfferingRef productOfferingRef1 = new ProductOfferingRef();
        productOfferingRef1.setId("POR01");
        productOfferingRef1.setCode("200");
        productOfferingRef1.setType(ProductOfferingRef.TypeEnum.PRODUCT);

        ProductOrderItem productOrderItem1 = new ProductOrderItem();
        productOrderItem1.setId("P01");
        productOrderItem1.setAction(OrderItemActionType.ADD);
        productOrderItem1.setProductOffering(productOfferingRef1);
        productOrderItems.add(productOrderItem1);

        ProductOfferingRef productOfferingRef2 = new ProductOfferingRef();
        productOfferingRef2.setId("POR02");
        productOfferingRef2.setCode("200");
        productOfferingRef2.setType(ProductOfferingRef.TypeEnum.PRODUCT);

        ProductOrderItem productOrderItem2 = new ProductOrderItem();
        productOrderItem2.setId("P02");
        productOrderItem2.setAction(OrderItemActionType.ADD);
        productOrderItem2.setProductOffering(productOfferingRef2);
        productOrderItems.add(productOrderItem2);

        productOrder1.setId("1");
        productOrder1.setCurrentStatus(currentStatus1);
        productOrder1.setIssuesTracking(issueTrackList1);
        productOrder1.setHref("https://productorder.com/productorder/1");
        productOrder1.setDescription("Product order good");
        productOrder1.setExternalId("PO01");
        productOrder1.setCreatedDate(OffsetDateTime.now());
        productOrder1.setLastModifiedDate(OffsetDateTime.MIN);
        productOrder1.setOrderItems(productOrderItems);

        productOrderList.add(productOrder1);

        // productorder 2
        ProductOrder productOrder2 = new ProductOrder();

        CurrentStatus currentStatus2 = new CurrentStatus();
        currentStatus2.setVlocityStatus("Order Success!");
        currentStatus2.setName(CurrentStatus.NameEnum.COMPLETED);
        currentStatus2.setDefaultNextStatus("COMPLETE");
        currentStatus2.setDefaultPreviousStatus("PENDING");

        List<IssueTrack> issueTrackList2 = new ArrayList<>();

        IssueTrack issueTrack3 = new IssueTrack();
        issueTrack3.setCurrentStatus("PENDING");
        issueTrack3.setRequestedStatus("PASS");
        issueTrack3.setIssue("GOOD");
        issueTrack3.setIssueDate(OffsetDateTime.now());
        issueTrackList2.add(issueTrack3);

        IssueTrack issueTrack4 = new IssueTrack();
        issueTrack4.setCurrentStatus("COMPLETE");
        issueTrack4.setRequestedStatus("PASS");
        issueTrack4.setIssue("GOOD");
        issueTrack4.setIssueDate(OffsetDateTime.now());
        issueTrackList2.add(issueTrack4);

        List<ProductOrderItem> productOrderItems2 = new ArrayList<>();
        ProductOfferingRef productOfferingRef3 = new ProductOfferingRef();
        productOfferingRef3.setId("POR03");
        productOfferingRef3.setCode("200");
        productOfferingRef3.setType(ProductOfferingRef.TypeEnum.PRODUCT);

        ProductOrderItem productOrderItem3 = new ProductOrderItem();
        productOrderItem3.setId("P03");
        productOrderItem3.setAction(OrderItemActionType.ADD);
        productOrderItem3.setProductOffering(productOfferingRef1);
        productOrderItems2.add(productOrderItem3);

        ProductOfferingRef productOfferingRef4 = new ProductOfferingRef();
        productOfferingRef4.setId("POR04");
        productOfferingRef4.setCode("200");
        productOfferingRef4.setType(ProductOfferingRef.TypeEnum.PRODUCT);

        ProductOrderItem productOrderItem4 = new ProductOrderItem();
        productOrderItem4.setId("P04");
        productOrderItem4.setAction(OrderItemActionType.ADD);
        productOrderItem4.setProductOffering(productOfferingRef2);
        productOrderItems2.add(productOrderItem4);

        productOrder2.setId("2");
        productOrder2.setCurrentStatus(currentStatus2);
        productOrder2.setIssuesTracking(issueTrackList2);
        productOrder2.setHref("https://productorder.com/productorder/2");
        productOrder2.setDescription("Product order good");
        productOrder2.setExternalId("PO02");
        productOrder2.setCreatedDate(OffsetDateTime.now());
        productOrder2.setLastModifiedDate(OffsetDateTime.MIN);
        productOrder2.setOrderItems(productOrderItems2);

        productOrderList.add(productOrder2);


        return productOrderList;
    }

    public ProductOrder getProductOrderByID(String id){

        logger.info("The getProductOrderByID function has been called where the ProductOrder data by id is stored");

        List<ProductOrder> productOrderList = getAll();
        ProductOrder productOrder = new ProductOrder();

        productOrder = productOrderList.get(Integer.parseInt(id) - 1);

        return productOrder;
    }

    public CreateOrderResponse addProductOrder(ProductOrderCreate productOrderCreate){

        productOrderCreates.add(productOrderCreate);
        logger.info("Product order is created!");
        // set create order response
        createOrderResponse.setOrderId(String.valueOf(new Random().nextInt(10)*10));
        logger.info("random ID: " + String.valueOf(new Random().nextInt(10)*10));
        createOrderResponse.setStatus("IN PROGRESS");

        return createOrderResponse;
    }



}
