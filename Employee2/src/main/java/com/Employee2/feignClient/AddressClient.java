package com.Employee2.feignClient;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Employee2.response.AddressResponse;

// http://localhost:8081/Address/api/address/1

@FeignClient(name = "Address" , url = "http://localhost:8081/Address/api/")
public interface AddressClient { //proxy
	
	@GetMapping("/address/{id}")
 public AddressResponse getAddressByEmployeeId(@PathVariable("id") int id);
	
	// we don't need to give implementation , spring will create the implementation for this class.

}
