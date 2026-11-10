package com.eatm.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eatm.dto.AddressDto;
import com.eatm.dto.EmployeeDto;
import com.eatm.dto.TaskDto;
import com.eatm.entity.Address;
import com.eatm.entity.Employee;
import com.eatm.entity.Task;

@Component
public class EntityMapper {

	@Autowired
	ModelMapper modelMapper;
	
	public Employee convertEmployeeDtoToEntity(EmployeeDto employeeDto) {
		return modelMapper.map(employeeDto, Employee.class);
	}
	
	public Address convertAddressDtoToEntity(AddressDto addressDto) {
		return modelMapper.map(addressDto, Address.class);
	}
	
	public Task convertTaskDtoToEntity(TaskDto taskDto) {
		return modelMapper.map(taskDto, Task.class);
	}	
	
	public EmployeeDto convertEntityToEmployeeDto(Employee employee) {
		return modelMapper.map(employee, EmployeeDto.class);
	}
	
	public AddressDto convertEntityToAddressDto(Address address) {
		return modelMapper.map(address, AddressDto.class);
	}
	
	public TaskDto convertEntityToTaskDto(Task task) {
		return modelMapper.map(task, TaskDto.class);
	}
	
}
