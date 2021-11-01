package com.vietsherlock.datastore.mapper;

import com.vietsherlock.datastore.models.ProductOrderItem;
import com.vietsherlock.datastore.models.ProductOrderItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductOrderItemMapper {

    ProductOrderItemDTO productOItoDTO (ProductOrderItem productOrderItem);

}
