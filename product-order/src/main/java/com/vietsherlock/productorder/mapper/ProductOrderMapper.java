package com.vietsherlock.productorder.mapper;

import com.vietsherlock.productorder.server.models.ProductOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProductOrderMapper {

//    @Mapping(source = "createdDate",target = "createdDate",dateFormat = "org.threeten.bp.OffsetDateTime")
    ProductOrder productOrderToProductOrder(com.vietsherlock.productorder.restclient.model.ProductOrder productOrder);

}
