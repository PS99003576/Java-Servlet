package com.ltts.projectname.model;

import java.sql.Date;

public class user {
	private String emailid;
	private String mobile;
	private String name;
	private Date dob;
	private String address;
	private String password;
	private String usertype;
	public user(String emailid, String mobile, String name, Date dob, String address, String password,
			String usertype) {
		super();
		this.emailid = emailid;
		this.mobile = mobile;
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.password = password;
		this.usertype = usertype;
	}
	public user() {
		super();
	}
	
	
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	  public user(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	@Override public String toString() { return "user [emailid=" + emailid +
	  ", mobile=" + mobile + ", name=" + name + ", dob=" + dob + ", address=" +
	  address + ", password=" + password + ", usertype=" + usertype + "]"; }
	 
	
	
	
}
