package com.vietsherlock.datastore.repository;

import com.vietsherlock.datastore.models.ProductOrder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataMongoTest
class ProductOrderRepositoryTest {

    @Autowired
    ProductOrderRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void isShouldFindProductOrderById() {
        //given
        ProductOrder productOrder = new ProductOrder();
        productOrder.setHref("http://productorder");
//        log
        ProductOrder productOrderTest = underTest.save(productOrder);

        //when
        ProductOrder expected = underTest.findAllById(productOrderTest.getId());

        //then
        assertThat(expected).isEqualTo(productOrderTest);
    }
}