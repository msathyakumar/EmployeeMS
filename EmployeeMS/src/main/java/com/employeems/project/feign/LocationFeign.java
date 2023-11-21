package com.employeems.project.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.employeems.project.model.Location;

@FeignClient("LocationMS")
public interface LocationFeign {
	
	@GetMapping("/get/{id}")
	public Location getById(@PathVariable("id") String id);

}
