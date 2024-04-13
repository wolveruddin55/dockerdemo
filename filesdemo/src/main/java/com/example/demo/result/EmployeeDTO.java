package com.example.demo.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
	private Long employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String hireDate;
	private String jobTitle;
	private String department;
	private String salary;
}
