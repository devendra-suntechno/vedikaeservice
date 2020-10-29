package com.vedika.functionhall.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vedika.functionhall.model.GenericResponse;
import com.vedika.functionhall.model.Response;
import com.vedika.functionhall.model.User;
import com.vedika.functionhall.service.UserService;

@RestController
@RequestMapping("/api")
public class RegisterController {
	

	@Autowired
	private UserService userservice;

	@PostMapping(path = "/registerUser")
	public GenericResponse<Response> registerUser(@Valid @RequestBody User user,BindingResult binding) throws Exception {
		 GenericResponse<Response> response=new GenericResponse<Response>();
		 
			String response1 = userservice.findUserByMobilenumber(user);
		  Response response2=new Response(); 
		  response2.setMsg(response1);
		response.setData(response2);
		if(binding.hasFieldErrors()) {
			DefaultMessageSourceResolvable error = binding.getFieldError();
			throw new Exception(error.getDefaultMessage());
		}
		return response;
	}
	@PostMapping(path = "/availbleUserId")
	public GenericResponse<Response> availableUser(@Valid @RequestParam String userId) {

		GenericResponse<Response> response = new GenericResponse<Response>();

		String result = userservice.finByUser(userId);
Response response1= new Response();
response1.setMsg(result);
		
		response.setMsg(result);
		return response;

	}

}
