package com.vietsherlock.productorder.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.vietsherlock.productorder.restclient.model.ProductOrder;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductOrderDTO extends ProductOrder {

    @JsonProperty("createdDate")
    private String createdDate = null;
    @JsonProperty("lastModifiedDate")
    private OffsetDateTime lastModifiedDateEdited = null;
    @JsonProperty("orderItems")
    private List<ProductOrderItemDTO> orderItems = new ArrayList<>();


}
