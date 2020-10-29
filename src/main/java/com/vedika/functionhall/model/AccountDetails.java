package com.vedika.functionhall.model;

public class AccountDetails {
	private String accountnumber;
	private String accountname;
	private String accounttype;
	private String bankname;
	private String branch;
	private String ifsc;
	private String pannumber;
	public String getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getAccountname() {
		return accountname;
	}
	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}
	public String getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public String getPannumber() {
		return pannumber;
	}
	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}
	@Override
	public String toString() {
		return "AccountDetails [accountnumber=" + accountnumber + ", accountname=" + accountname + ", accounttype="
				+ accounttype + ", bankname=" + bankname + ", branch=" + branch + ", ifsc=" + ifsc + ", pannumber="
				+ pannumber + "]";
	}

	
}
