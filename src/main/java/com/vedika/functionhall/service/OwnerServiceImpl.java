package com.vedika.functionhall.service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.MongoException;
import com.mongodb.client.result.UpdateResult;
import com.vedika.functionhall.controller.SearchIds;
import com.vedika.functionhall.exception.OwnerControllerException;
import com.vedika.functionhall.model.AccountDetails;
import com.vedika.functionhall.model.Details;
import com.vedika.functionhall.model.FunctionHall;
import com.vedika.functionhall.model.Location;
import com.vedika.functionhall.model.Owner;
import com.vedika.functionhall.model.PublishDetails;
import com.vedika.functionhall.model.TwilioCreden;
import com.vedika.functionhall.repository.OwnerRepository;

@Service
public class OwnerServiceImpl implements OwnerService {

	@Autowired
	private OwnerRepository ownerRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	private static final Logger LOGGER = LoggerFactory.getLogger(OwnerServiceImpl.class);



	public Owner saveOrUpdateOwner(Owner owner) {
		return ownerRepository.save(owner);
	}

	@Override
	public List<Owner> findFunctionHallByNameAndCity(String city, String name) {
		return ownerRepository.findFunctionHallByNameAndCity(city, name);
	}

	@Override
	public void update(String correlationid, String imageUrl) throws FileNotFoundException, RuntimeException {
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("functionhall.correlationid").is(correlationid));
			Owner ownerref = mongoTemplate.findOne(query, Owner.class);
			System.out.println(ownerref);
			UpdateResult update = mongoTemplate.updateMulti(query,
					new Update().addToSet("functionhall.$.imageUrl", imageUrl), Owner.class);
			System.out.println(update);
		} catch (MongoException e) {
			System.out.println("nessary file not present" + e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Owner findByownerID(String ownerId) {
		// TODO Auto-generated method stub
		return ownerRepository.findByownerID(ownerId);
	}

	@Override
	public void updatefunctionhall(String ownerId, PublishDetails publishdetails, int functionhallId) {
		// TODO Auto-generated method stub
		Criteria findByownerId = Criteria.where("ownerId").is(ownerId);
		Criteria findByfunctionhallId = Criteria.where("functionhall")
				.elemMatch(Criteria.where("functionhallId").is(functionhallId));
		BasicQuery query = new BasicQuery(findByownerId.getCriteriaObject(), findByfunctionhallId.getCriteriaObject());

		Owner owner = mongoTemplate.findOne(query, Owner.class);
		System.out.println(owner);
		if (owner != null) {

			List<FunctionHall> functionhalls = owner.getFunctionhall();

			Iterator<FunctionHall> iter = functionhalls.iterator();
			while (iter.hasNext()) {
				FunctionHall functionhall = iter.next();
				FunctionHall functionhalldata = publishdetails.getDetails();
				Location location = publishdetails.getLocation();
				AccountDetails accountdetails = publishdetails.getAccountDetails();

				if (null != functionhalldata && null != accountdetails && null != location) {

					functionhall.setCity(location.getCity());
					functionhall.setState(location.getState());
					functionhall.setStreetAddress(location.getStreetaddress());
					functionhall.setZipCode(location.getZipcode());
					functionhall.setCountry(location.getCountry());
					functionhall.setName(functionhalldata.getName());
					functionhall.setFunctionhalldescription(functionhalldata.getFunctionhalldescription());
					functionhall.setMaximumguest(functionhalldata.getMaximumguest());
					functionhall.setImageUrl(functionhalldata.getImageUrl());
					functionhall.setAirconditioning(functionhalldata.getAirconditioning());
					functionhall.setDancefloor(functionhalldata.getDancefloor());
					functionhall.setLightingsystem(functionhalldata.getLightingsystem());
					functionhall.setInternet(functionhalldata.getInternet());
					functionhall.setNoalcohol(functionhalldata.getNoalcohol());
					functionhall.setNosmoking(functionhalldata.getNosmoking());
					functionhall.setParking(functionhalldata.getParking());
					functionhall.setSoundsystem(functionhalldata.getSoundsystem());
					functionhall.setEventspace(functionhalldata.getEventspace());
					functionhall.setWeddinghall(functionhalldata.getWeddinghall());
					functionhall.setNightclub(functionhalldata.getNightclub());
					functionhall.setPerformance(functionhalldata.getPerformance());
					functionhall.setConference(functionhalldata.getConference());
					functionhall.setPartyroom(functionhalldata.getPartyroom());
					functionhall.setBanquethall(functionhalldata.getBanquethall());

				}
				functionhalls.add(functionhall);
			}

			owner.setFunctionhall(functionhalls);

			System.out.println(functionhalls);

			//

		}
		System.out.println(owner);

		// System.out.println(ownerdata);

		// accountdetailslist.add(accountdata);
		// ownerdata.setFunctionhall(functionhalllist);
		// ownerdata.setAccountdetails(accountdetailslist);
		// System.out.println(ownerdata);

		// mongoTemplate.save(ownerdata);

		// UpdateResult update = mongoTemplate.updateFirst(query, new
		// Update().push("functionhall", functionhalllist),
		// Owner.class);
		// System.out.println(update);
		// if (update.getModifiedCount() == 1) {

	}

	@Override
	public String deletefunctionhall(String ownerId,int functionhallId) throws OwnerControllerException, NullPointerException {
		// TODO Auto-generated method stub

		String msg1 = "somthing went wrong please try again";
		String msg2 = "Functionhall deleted Sucessfully";
	//	if (searchid == null) {
		//	throw new OwnerControllerException("ownerId  should not be null :" + searchid.getOwnerId());
		//}
	//	Criteria findByownerId = Criteria.where("ownerId").is(ownerId);
		Criteria findByfunctionhallId = Criteria.where("functionhall")
				.elemMatch(Criteria.where("functionhallId").is(functionhallId));
		BasicQuery query = new BasicQuery( findByfunctionhallId.getCriteriaObject());

		Owner owner = mongoTemplate.findOne(query, Owner.class);
		System.out.println(owner);
	/*	if (owner == null) {
			throw new OwnerControllerException(
					"functionhall not found : " + searchid.getFuntionhallId() + searchid.getOwnerId());

		} */
		System.out.println(owner);

		List<FunctionHall> hall = owner.getFunctionhall();

		System.out.println(hall);
		for (FunctionHall hall1 : hall) {

			if (hall1.getFunctionhallId() == functionhallId) {
				UpdateResult update = mongoTemplate.updateFirst(query, new Update().pull("functionhall", hall1),
						Owner.class);

				System.out.println(update);
				if (update.getModifiedCount() == 1) {
					return msg2;
				}
			}

		}

		return msg1;
	}
}
