package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EmployeeEntity;

@Repository
public interface EmployeeDAO extends JpaRepository<EmployeeEntity, Long> {

	@Query(value="select * from employee", nativeQuery = true)
	Optional<List<EmployeeEntity>> findAllEmployees();
	
	@Query(value="select * from employee where email =:email", nativeQuery = true)
	Optional<List<EmployeeEntity>> findEmployeeByEmail(@Param("email") String email);
}
