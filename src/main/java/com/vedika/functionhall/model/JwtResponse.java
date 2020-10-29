package com.vedika.functionhall.model;

import java.io.Serializable;
import java.util.Date;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;

	private String msg;
	private String firstname;
	private  String jwttoken;
	private  String expirationtime;
	public String getMsg() {
		return msg;
	}
	@Override
	public String toString() {
		return "JwtResponse [msg=" + msg + ", firstname=" + firstname + ", jwttoken=" + jwttoken + ", expirationtime="
				+ expirationtime + "]";
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getJwttoken() {
		return jwttoken;
	}
	public void setJwttoken(String jwttoken) {
		this.jwttoken = jwttoken;
	}
	public String getExpirationtime() {
		return expirationtime;
	}
	public void setExpirationtime(String expirationtime) {
		this.expirationtime = expirationtime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
