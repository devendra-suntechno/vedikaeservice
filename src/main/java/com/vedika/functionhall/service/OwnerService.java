package com.vedika.functionhall.service;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vedika.functionhall.controller.SearchIds;
import com.vedika.functionhall.exception.OwnerControllerException;
import com.vedika.functionhall.model.Owner;
import com.vedika.functionhall.model.PublishDetails;

@Service
public interface OwnerService {

	Owner saveOrUpdateOwner(Owner owner);

	List<Owner> findFunctionHallByNameAndCity(String city, String name) throws OwnerControllerException;

	void update(String correlationid, String imageUrl) throws FileNotFoundException, RuntimeException;

	Owner findByownerID(String _id);

	void updatefunctionhall(String ownerId, PublishDetails publishdetails, int functionhallId);

	String deletefunctionhall(String ownerId,int functionhallId) throws OwnerControllerException, NullPointerException;

}