package com.vietsherlock.datastore.mapper;

import com.vietsherlock.datastore.models.ProductOrder;
import com.vietsherlock.datastore.models.ProductOrderDTO;
import org.mapstruct.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring", uses = {ProductOrderItemMapper.class})
public interface ProductOrderMapper {

    Logger logger = LoggerFactory.getLogger(ProductOrderMapper.class);
    ProductOrder PRODUCT_ORDER = null;

    @Mapping(source = "productOrder.lastModifiedDateEdited", target = "lastModifiedDate")
    @Mapping(source = "productOrder.orderItems", target = "orderItems")
    @Mapping(source = "productOrder.createdDate", target = "createdDate", qualifiedByName = "createdDate")
    ProductOrderDTO productOrderToDTO(ProductOrder productOrder);

    @Named("createdDate")
    default OffsetDateTime stringToOffsetDateTime(String createdDate){
        createdDate = PRODUCT_ORDER.getCreatedDate();
        OffsetDateTime dateTime1 = OffsetDateTime.parse(createdDate,
                DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss Z"));
        logger.info("dateTime: " + dateTime1);
        return dateTime1;
    }

}
