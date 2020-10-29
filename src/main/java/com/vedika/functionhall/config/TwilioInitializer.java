/*package com.vedika.functionhall.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.twilio.Twilio;
import com.vedika.functionhall.model.TwilioCreden;

@Configuration
public class TwilioInitializer {


	private final static Logger LOGGER = LoggerFactory.getLogger(TwilioInitializer.class);

	private final TwilioConfiguration twilioConfiguration;
	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	public TwilioInitializer(TwilioConfiguration twilioConfiguration) {
		this.twilioConfiguration = twilioConfiguration;
		Query query1 = new Query();
		query1.addCriteria(Criteria.where("_id").is("5f64dbaed9d8b8b70f05c8aa"));
		TwilioCreden userdata1 = mongoTemplate.findOne(query1, TwilioCreden.class);
		Twilio.init(userdata1.getAccount_sid(), userdata1.getAuthToken());
		LOGGER.info("Twilio initialized ... with account sid {} ", twilioConfiguration.getAccount_sid());
	}
} */
