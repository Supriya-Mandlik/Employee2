package com.Employee2.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee2.entity.Employee;
import com.Employee2.feignClient.AddressClient;
import com.Employee2.repository.EmployeeRepository;
import com.Employee2.response.AddressResponse;
import com.Employee2.response.EmployeeResponse;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository EmployeeRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AddressClient addressClient;
	
	public EmployeeResponse getEmployeeById(int id) {
		
		// db call -> fetch employee 1
		
		// employee -> EmployeeResponse
		// we can not expose our actual employee class to outer world
		// therefore we create EmployeeResponse class
		// now we are exposing employeeResponse object instead of employee object.
		
		Employee employee = EmployeeRepo.findById(id).get();  // DB call
		
		 EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
		
		
		 AddressResponse addressResponse = addressClient.getAddressByEmployeeId(id);
		 
		 employeeResponse.setAddressResponse(addressResponse); 
		
		
		return employeeResponse ;
		
	}
        
	
}
