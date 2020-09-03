package com.vedika.functionhall.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vedika.functionhall.model.JwtResponse;
import com.vedika.functionhall.model.ResponseObject;
import com.vedika.functionhall.model.User;
import com.vedika.functionhall.service.SecurityServcie;
import com.vedika.functionhall.service.UserService;
import com.vedika.functionhall.tokenservice.JwtTokenUtil;

@RestController
@RequestMapping("/api")
public class LoginController {
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserService userservice;
	@Autowired
	private MongoTemplate mongoTemplate;

	@RequestMapping(value = "/login/verification", method = RequestMethod.POST)
	public String sendOTP(@RequestParam String mobileNumber) throws NullPointerException {

		return userservice.findUserByMobilenumbers(mobileNumber);

	}

	@RequestMapping(value = "login/verification", method = RequestMethod.PUT)
	public ResponseEntity<JwtResponse> verify(@RequestParam String mobileNumber) {

		String msg = "OTP IS NOT VALID PLEASE TRY AGAIN";
		boolean isValid = true;

		if (isValid) {

			String msg1 = "Otp success";
			final String token = jwtTokenUtil.generateToken(mobileNumber);
			final Date expirationtime = jwtTokenUtil.getExpirationDateFromToken(token);
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
			String strDate = dateFormat.format(expirationtime);
			System.out.println(expirationtime);
			JwtResponse res = new JwtResponse(token, strDate);
			System.out.println(res);
			res.getExpirationtime();
			return ResponseEntity.ok(new JwtResponse(token, strDate));
		}
		return ResponseEntity.ok(new JwtResponse(msg, msg));

	}

}
