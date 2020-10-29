package com.vedika.functionhall.controller;

public class SearchIds {
	private int funtionhallId;
	private String ownerId;
	
	public int getFuntionhallId() {
		return funtionhallId;
	}
	public void setFuntionhallId(int funtionhallId) {
		this.funtionhallId = funtionhallId;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	@Override
	public String toString() {
		return "SearchIds [funtionhallId=" + funtionhallId + ", ownerId=" + ownerId + "]";
	}
	

}
