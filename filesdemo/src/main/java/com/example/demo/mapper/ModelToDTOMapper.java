package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.result.EmployeeDTO;
import com.example.demo.result.Utility;

@Mapper(componentModel = "spring")
public interface ModelToDTOMapper {

	ModelToDTOMapper MAPPERInstance = Mappers.getMapper(ModelToDTOMapper.class);

	@Mapping(source = "hireDate", target = "hireDate", dateFormat = Utility.DATE_FORMAT)
	@Mapping(source = "salary", target = "salary", numberFormat = Utility.NUMBER_FORMAT)
	EmployeeDTO fromEmployeeModel(EmployeeEntity employeeModel);

	List<EmployeeDTO> fromEmployeeModel(List<EmployeeEntity> employeeModel);
}
