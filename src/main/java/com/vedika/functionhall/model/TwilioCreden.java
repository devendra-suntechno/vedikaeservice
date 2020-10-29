package com.vedika.functionhall.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "twiliocredentails")
public class TwilioCreden{
	private String _id;
	private String account_sid;
	private String authToken;
	@Override
	public String toString() {
		return "fd [account_sid=" + account_sid + ", authToken=" + authToken + "]";
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getAccount_sid() {
		return account_sid;
	}
	public void setAccount_sid(String account_sid) {
		this.account_sid = account_sid;
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
}
