package com.vietsherlock.datastore.mapper;

import com.vietsherlock.datastore.models.ProductOrder;
import com.vietsherlock.datastore.models.ProductOrderDTO;
import org.mapstruct.*;

import java.util.UUID;

@Mapper(
        componentModel = "spring",
        uses = {ProductOrderItemMapper.class, CurrentStatusMapper.class, DateTimeMapper.class},
        imports = {UUID.class}
)
public interface ProductOrderMapper {

    @Mapping(source = "productOrder.lastModifiedDateEdited", target = "lastModifiedDate")
    @Mapping(source = "productOrder.externalId", target = "externalId", defaultExpression = "java(UUID.randomUUID().toString())")
    @Mapping(target = "baseType", constant = "This's base Type!")
    ProductOrderDTO productOrderToDTO(ProductOrder productOrder);

}
