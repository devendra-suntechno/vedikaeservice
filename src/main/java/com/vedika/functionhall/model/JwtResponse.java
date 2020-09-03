package com.vedika.functionhall.model;


import java.io.Serializable;
import java.util.Date;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
    private final String Expirationtime;
    private String msg;
    
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public JwtResponse(String jwttoken, String strDate) {
		this.Expirationtime =strDate ;
		this.jwttoken = jwttoken;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getJwttoken() {
		return jwttoken;
	}

	public String getExpirationtime() {
		return Expirationtime;
	}

}


