package com.vietsherlock.datastore.mapper;

import com.vietsherlock.datastore.models.CurrentStatusDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
public class EnumMapper {

    CurrentStatusDTO.NameEnum stringToNameEnum(String value){
        return CurrentStatusDTO.NameEnum.fromValue(value);
    }

}
