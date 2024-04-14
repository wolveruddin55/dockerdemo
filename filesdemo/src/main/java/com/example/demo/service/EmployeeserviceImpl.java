package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.mapper.ModelToDTOMapper;
import com.example.demo.result.CustomException;
import com.example.demo.result.EmployeeDTO;
import com.example.demo.result.Result;
import com.example.demo.result.Utility;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeserviceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;

	@Autowired
	ModelToDTOMapper modelToDTOMapper;

	@Override
	public Result findAllEmployees() {
		Result result = new Result();
		try {
			Optional<List<EmployeeDTO>> employeeDTOsList = Optional
					.of(modelToDTOMapper.fromEmployeeModel(employeeDAO.findAllEmployees().get()));
			log.info(">>>>>>>>>>>>>>>>>>>> ",employeeDAO.findAllEmployees().get().get(0).getEmail());
			if (employeeDTOsList.isPresent()) {
				result.setData(employeeDTOsList);
				result.setMessage(Utility.SUCCESS_MESSAGE);
				result.setStatusCode(HttpStatus.OK.value());
			} else {
				log.info(">>>>>>>>>>>>>>>>>> ", employeeDTOsList.get().get(0).getEmail());
				result.setData(employeeDTOsList);
				result.setMessage(Utility.NOT_FOUND);
				result.setStatusCode(HttpStatus.NOT_FOUND.value());
			}
		} catch (Exception e) {
			throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
		return result;
	}

	@Override
	public Result findEmployeeByEmail(String email) {
		Result result = new Result();
		try {
			Optional<List<EmployeeDTO>> employeeDTOsList = Optional
					.of(modelToDTOMapper.fromEmployeeModel(employeeDAO.findEmployeeByEmail(email).get()));
			if (employeeDTOsList.isPresent()) {
				result.setData(employeeDTOsList);
				result.setMessage(Utility.SUCCESS_MESSAGE);
				result.setStatusCode(HttpStatus.OK.value());
			} else {
				result.setData(employeeDTOsList);
				result.setMessage(Utility.NOT_FOUND);
				result.setStatusCode(HttpStatus.NOT_FOUND.value());
			}
		} catch (Exception e) {
			throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
		return result;
	}
	
}