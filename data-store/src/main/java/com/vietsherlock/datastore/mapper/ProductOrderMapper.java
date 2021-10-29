package com.vietsherlock.datastore.mapper;

import com.vietsherlock.datastore.models.ProductOrder;
import com.vietsherlock.datastore.models.ProductOrderDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {ProductOrderItemMapper.class, CurrentStatusMapper.class, DateTimeMapper.class})
public interface ProductOrderMapper {

    @Mapping(source = "productOrder.lastModifiedDateEdited", target = "lastModifiedDate")
    ProductOrderDTO productOrderToDTO(ProductOrder productOrder);

}
