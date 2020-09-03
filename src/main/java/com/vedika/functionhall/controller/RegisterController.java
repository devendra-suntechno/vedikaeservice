package com.vedika.functionhall.controller;

import java.util.HashMap;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedika.functionhall.model.User;
import com.vedika.functionhall.service.UserService;

@RestController
@RequestMapping("/api")
public class RegisterController {

	@Autowired
	private UserService userservice;

	@PostMapping(path = "/registerUser")
	public String registerUser(@Valid @RequestBody User user)
			throws Exception {

		String userExists = userservice.findUserByMobilenumber(user);
  System.out.println(userExists);
 return userExists;
}
}
