package com.vietsherlock.datastore.mapper;

import com.vietsherlock.datastore.models.CurrentStatus;
import com.vietsherlock.datastore.models.CurrentStatusDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {EnumMapper.class})
public interface CurrentStatusMapper {

    CurrentStatusDTO currentStatusToDTO(CurrentStatus currentStatus);

}
