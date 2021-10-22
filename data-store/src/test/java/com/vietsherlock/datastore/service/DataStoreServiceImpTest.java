package com.vietsherlock.datastore.service;

import com.vietsherlock.datastore.models.ProductOrderCreate;
import com.vietsherlock.datastore.repository.ProductOrderCreateRepository;
import com.vietsherlock.datastore.repository.ProductOrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DataStoreServiceImpTest {

    @Mock
    private ProductOrderRepository productOrderRepository;
    @Mock
    private ProductOrderCreateRepository productOrderCreateRepository;
    private DataStoreServiceImp underTest;

    @BeforeEach
    void setUp() {
        underTest = new DataStoreServiceImp(productOrderRepository, productOrderCreateRepository);
    }

    @Test
    void canGetProductOrderByID() {
        //given
        String id = "61721fde3ff88b21ec0a53be";

        //when
        underTest.getProductOrderByID(id);

        //then
        ArgumentCaptor<String> IdArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(productOrderRepository).findAllById(IdArgumentCaptor.capture());
        String capturedId = IdArgumentCaptor.getValue();
        assertThat(capturedId).isEqualTo(id);
    }

    @Test
//    @Disabled
    void canAddProductOrder() {
        //given
        ProductOrderCreate productOrderCreate = new ProductOrderCreate();
        productOrderCreate.setCategory(ProductOrderCreate.CategoryEnum.NEW);
        productOrderCreate.setExternalId("61721fde3ff88b21ec0a53be");
        productOrderCreate.setSubscription(null);
        productOrderCreate.setBillingAccount(null);
    }
}