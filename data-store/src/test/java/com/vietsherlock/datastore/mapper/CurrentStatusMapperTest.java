package com.vietsherlock.datastore.mapper;

import com.vietsherlock.datastore.models.CurrentStatus;
import com.vietsherlock.datastore.models.CurrentStatusDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CurrentStatusMapperTest {

    @Autowired
    private CurrentStatusMapper currentStatusMapper = new CurrentStatusMapperImpl();

    @Test
    void canMappingFromCurrentStatusToDTO() {
        //given
        CurrentStatus currentStatus = new CurrentStatus();
        currentStatus.setVlocityStatus("Order Success!");
        currentStatus.setPreviousStates(Arrays.asList("CANCEL", "ORDERING", "PENDING"));
        currentStatus.setNextStates(Arrays.asList("ORDERED", "SHIPPING"));
        currentStatus.setName("Acknowledged");
        currentStatus.setDescription("Breve description del estado del procesamiento retornado");
        currentStatus.setDefaultPreviousStatus("PENDING");
        currentStatus.setDefaultNextStatus("SHIPPING");

        //when
        CurrentStatusDTO expectedMapping = currentStatusMapper.currentStatusToDTO(currentStatus);

        //then
        assertThat(expectedMapping.getVlocityStatus()).isEqualTo(currentStatus.getVlocityStatus());
        assertThat(expectedMapping.getPreviousStates()).isEqualTo(currentStatus.getPreviousStates());
        assertThat(expectedMapping.getNextStates()).isEqualTo(currentStatus.getNextStates());
        assertThat(expectedMapping.getDescription()).isEqualTo(currentStatus.getDescription());
        assertThat(expectedMapping.getDefaultPreviousStatus()).isEqualTo(currentStatus.getDefaultPreviousStatus());
        assertThat(expectedMapping.getDefaultNextStatus()).isEqualTo(currentStatus.getDefaultNextStatus());
        assertThat(expectedMapping.getName()).isEqualTo(CurrentStatusDTO.NameEnum.ACKNOWLEDGED);

    }

    @Test
    void canMappingFromStringToNameEnum() {
        //given
        String value = "Acknowledged";

        //when
        CurrentStatusDTO.NameEnum expectedMapping =  CurrentStatusDTO.NameEnum.fromValue(value);

        //then
        assertThat(expectedMapping).isEqualTo(CurrentStatusDTO.NameEnum.ACKNOWLEDGED);
    }
}