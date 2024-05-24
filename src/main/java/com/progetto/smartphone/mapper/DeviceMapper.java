package com.progetto.smartphone.mapper;

import com.progetto.smartphone.dto.DeviceDTO;
import com.progetto.smartphone.entity.Device;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeviceMapper {

    DeviceMapper INSTANCE = Mappers.getMapper(DeviceMapper.class);

//    @Mapping(target = "id", ignore = true)
    @Mapping(target = "employee", ignore = true)
    Device toEntity(DeviceDTO deviceDTO);
}
