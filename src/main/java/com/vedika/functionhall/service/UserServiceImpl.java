package com.vedika.functionhall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mongodb.MongoWriteException;
import com.vedika.functionhall.model.User;
import com.vedika.functionhall.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public User register(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	public String findUserByMobilenumber(User user) throws MongoWriteException {

		String msg = "user already register";
		String msg1 = "Something went wrong";
		String msg2 = "registration Success";
		try {
			if (user != null) {
				Query query = new Query();
				query.addCriteria(Criteria.where("userId").is(user.getUserId()));
				User userdata = mongoTemplate.findOne(query, User.class);
				System.out.println(userdata);
				if (userdata != null) {
					if (user.getUserId().equals(userdata.getUserId())) {

						return msg;
					}
				}
			}
		} catch (NullPointerException e) {
			System.out.print("NullPointerException Caught");
		} catch (MongoWriteException ex) {
			System.out.println("Entered values is already Exits in database" + ex);
		}
		User result = userRepository.save(user);

		if (result != null)
			return msg2;
		else
			return msg1;

	}

	@Override
	public String finByUser(String userId) {
		// TODO Auto-generated method stub

		String msg1 = "userId is not Available";
		String msg2 = "UserId is Availble";
		String msg = "something went worng";
		try {

			Query query = new Query();
			query.addCriteria(Criteria.where("userId").is(userId));
			User userdata = mongoTemplate.findOne(query, User.class);
			System.out.println(userdata);
			if (userdata != null) {
				if (userId.equals(userdata.getUserId()))

					return msg1;

			} else {
				return msg2;
			}

		} catch (NullPointerException e) {
			System.out.print("NullPointerException Caught");
		}
		return msg;

	}

}
