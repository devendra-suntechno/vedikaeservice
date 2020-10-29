package com.vedika.functionhall.service;

import javax.validation.Valid;

import com.vedika.functionhall.model.User;

public interface UserService {

	User register(User user);

	String findUserByMobilenumber(@Valid User user);
	String finByUser(String userId);

}