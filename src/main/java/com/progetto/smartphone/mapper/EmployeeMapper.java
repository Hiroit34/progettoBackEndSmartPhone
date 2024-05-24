package com.progetto.smartphone.mapper;

import com.progetto.smartphone.dto.EmployeeDTO;
import com.progetto.smartphone.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapping;



@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(target = "id", ignore = true)
    Employee toEntity(EmployeeDTO employeeDTO);
}
