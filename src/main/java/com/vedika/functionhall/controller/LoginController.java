package com.vedika.functionhall.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.vedika.functionhall.model.GenericResponse;
import com.vedika.functionhall.model.JwtResponse;
import com.vedika.functionhall.model.Response;
import com.vedika.functionhall.model.TwilioCreden;
import com.vedika.functionhall.model.User;
import com.vedika.functionhall.model.UserLogin;
import com.vedika.functionhall.tokenservice.JwtTokenUtil;

@RestController
@RequestMapping("/api")
public class LoginController {
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private MongoTemplate mongoTemplate;

	HashMap<String, UserLogin> otpdata = new HashMap<>();

	@RequestMapping(value = "/login/verification", method = RequestMethod.POST)
	public GenericResponse<Response> sendOTP(@RequestParam String mobileNumber)
			throws NullPointerException, IllegalArgumentException {
		GenericResponse<Response> response = new GenericResponse<Response>();
		Query query1 = new Query();
		query1.addCriteria(Criteria.where("_id").is("5f64dbaed9d8b8b70f05c8aa"));
		TwilioCreden userdata1 = mongoTemplate.findOne(query1, TwilioCreden.class);
		System.out.println(userdata1);
		Twilio.init(userdata1.getAccount_sid(), userdata1.getAuthToken());
		String message = "your not  registered with us please register";
		String message1 = "OTP SENT Successfully";
		if (mobileNumber == null || mobileNumber.isEmpty()) {

			throw new IllegalArgumentException("mobileNumber should not be Null");
		}
		if (mobileNumber != null) {
			try {
				Query query = new Query();
				query.addCriteria(Criteria.where("mobileNumber").is(mobileNumber));
				User userdata = mongoTemplate.findOne(query, User.class);

				if (userdata.getMobileNumber().equals(mobileNumber)) {

					UserLogin userlogin = new UserLogin();
					userlogin.setMobileNumber(mobileNumber);
					userlogin.setOtp(String.valueOf(new Random().nextInt(9999) + 1000));
					userlogin.setExpiretime(System.currentTimeMillis() + 200000);
					userlogin.setFirstName(userdata.getFirstName());

					otpdata.put(mobileNumber, userlogin);
					Message.creator(new PhoneNumber("+91" + mobileNumber), new PhoneNumber("+18647148412"),
							"Your vedika Login Authentication code is: " + userlogin.getOtp()).create();
					response.setMsg(message1);
					return response;
				}
			} catch (NullPointerException e) {
				System.out.print("NullPointerException Caught");
			}

		}
		response.setMsg(message);
		return response;

	}

	@RequestMapping(value = "login/verification", method = RequestMethod.PUT)
	public GenericResponse<JwtResponse> verifyotp(@RequestBody UserLogin user) {

		GenericResponse<JwtResponse> response = new GenericResponse<JwtResponse>();

		String msg = "Please Provide Otp";
		String msg1 = "Invalid OTP";
		String msg2 = "OTP has Expired";
		String msg3 = "Something went wrong Please Try again";

		if (user.getOtp() == null || user.getOtp().trim().length() <= 0) {

			response.setMsg(msg);

			return response;

		}

		UserLogin userdata = otpdata.get(user.getMobileNumber());
		if (userdata != null) {
			if (userdata.getExpiretime() >= System.currentTimeMillis()) {

				if (userdata.getOtp().equals(user.getOtp())) {
					String msg4 = "OTP Verified successfully";
					otpdata.remove(user.getMobileNumber());
					String token = jwtTokenUtil.generateToken(user.getMobileNumber());
					final Date expirationtime = jwtTokenUtil.getExpirationDateFromToken(token);
					final DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
					String strDate = dateFormat.format(expirationtime);
					String firstName = userdata.getFirstName();

					JwtResponse res = new JwtResponse();
					GenericResponse<JwtResponse> response1 = new GenericResponse<JwtResponse>();
					res.setJwttoken(token);

					res.setFirstname(firstName);
					res.setExpirationtime(strDate);
					res.setMsg(msg4);
					response1.setData(res);
					return response1;

				}
				response.setMsg(msg1);
				return response;

			}
			response.setMsg(msg2);
			return response;
		}
		response.setMsg(msg3);
		return response;

	}

}
