package com.vedika.functionhall.model;

public class UserLogin {
	private String mobileNumber;
	private String otp;
	private long expiretime;
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	@Override
	public String toString() {
		return "UserLogin [mobileNumber=" + mobileNumber + ", otp=" + otp + ", expiretime=" + expiretime
				+ ", getMobileNumber()=" + getMobileNumber() + ", getOtp()=" + getOtp() + ", getExpiretime()="
				+ getExpiretime() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	public long getExpiretime() {
		return expiretime;
	}
	public void setExpiretime(long expiretime) {
		this.expiretime = expiretime;
	}
	
	

}
