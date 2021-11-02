package com.vietsherlock.datastore.mapper;

import com.vietsherlock.datastore.models.CurrentStatus;
import com.vietsherlock.datastore.models.CurrentStatusDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//@Mapper(componentModel = "spring", uses = {EnumMapper.class})
@Mapper(componentModel = "spring")
public interface CurrentStatusMapper {
//    @Mapping(source = "name", target = "name")
    @Mapping(target = "name",
            expression = "java(stringToNameEnum(currentStatus.getName()))")
    CurrentStatusDTO currentStatusToDTO(CurrentStatus currentStatus);

    default CurrentStatusDTO.NameEnum stringToNameEnum(String value){
        return CurrentStatusDTO.NameEnum.fromValue(value);
    }

}
