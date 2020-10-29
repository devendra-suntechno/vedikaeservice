package com.vedika.functionhall.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vedika.functionhall.exception.OwnerControllerException;
import com.vedika.functionhall.model.GenericResponse;
import com.vedika.functionhall.model.Homepagesignin;
import com.vedika.functionhall.model.Response;

@RestController
@RequestMapping("/api")
public class HomePageController {

	String emailid = "info@suntechnoservices.com";
	String adminpassword = "Vedikas@2021";

	@RequestMapping(value = "/homepage", method = RequestMethod.POST)
	public GenericResponse<Response> Homepagelogin(@RequestBody Homepagesignin homepage) throws OwnerControllerException {
		GenericResponse<Response> response = new GenericResponse<Response>();
		String status = "";

		if(homepage.getEmail().isEmpty()&&homepage.getEmail().isEmpty()) {
			throw new OwnerControllerException("Please provide valid email or password");

		}
		
		if (homepage.getEmail().contentEquals(emailid) && homepage.getPassword().contentEquals(adminpassword)) {

			status = "success";
			response.setMsg(status);
			return response;
		} else {
			status = "email or password incorrect";

			response.setMsg(status);
			return response;

		}


	}

}
