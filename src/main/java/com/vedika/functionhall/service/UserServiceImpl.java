package com.vedika.functionhall.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mongodb.MongoWriteException;
import com.vedika.functionhall.model.ResponseObject;
import com.vedika.functionhall.model.User;
import com.vedika.functionhall.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private SecurityServcie securityservice;

	@Override
	public User register(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	public String findUserByMobilenumber(User user) throws MongoWriteException {

		String msg = "user already register";
		String msg2 = "registrationsuccess";
		try {
			if (user != null) {
				Query query = new Query();
				query.addCriteria(Criteria.where("mobileNumber").is(user.getMobileNumber()));
				User userdata = mongoTemplate.findOne(query, User.class);
				System.out.println(userdata);

				if (user.getMobileNumber().equals(userdata.getMobileNumber())) {

					return msg;
				}
			}
		} catch (NullPointerException e) {
			System.out.print("NullPointerException Caught");
		} catch (MongoWriteException ex) {
			System.out.println("Entered values is already Exits in database" + ex);
		}
		userRepository.save(user);

		return msg2;

	}

	@Override
	public String findUserByMobilenumbers(String mobileNumber) {
		String message = "your not  registered with us please register";
		String message1 = "OTP SENT Successfully";
		if (mobileNumber != null) {
			try {
				Query query = new Query();
				query.addCriteria(Criteria.where("mobileNumber").is(mobileNumber));
				User userdata = mongoTemplate.findOne(query, User.class);
				System.out.println(userdata);
				if (userdata.getMobileNumber().equals(mobileNumber)) {
					String twoFaCode = String.valueOf(new Random().nextInt(9999) + 1000);
					securityservice.send2FaCode(mobileNumber, twoFaCode);
					return message1;
				}
			} catch (NullPointerException e) {
				System.out.print("NullPointerException Caught");
			}
		}

		return message;
	}
}
