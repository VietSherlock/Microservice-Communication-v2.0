//package com.vietsherlock.datastore.mapper;
//
//import com.vietsherlock.datastore.models.CurrentStatus;
//import com.vietsherlock.datastore.models.CurrentStatusDTO;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = { CurrentStatusMapperImpl.class})
//class CurrentStatusMapperTest {
//
//    @Autowired
//    private CurrentStatusMapper currentStatusMapper;
//
//    @Test
//    void currentStatusToDTO() {
//        //given
//        CurrentStatus currentStatus = new CurrentStatus();
//        currentStatus.setName("ACKNOWLEDGED");
//        CurrentStatusDTO currentStatusDTO = new CurrentStatusDTO();
//        currentStatusDTO.setName(CurrentStatusDTO.NameEnum.ACKNOWLEDGED);
//
//        //when
//        CurrentStatusDTO expected = currentStatusMapper.currentStatusToDTO(currentStatus);
//
//        //then
//        assertThat(expected).isEqualTo(currentStatusDTO);
//
//    }
//}