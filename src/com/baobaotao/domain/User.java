package com.baobaotao.domain;

import java.io.Serializable;
import java.util.Date;


public class User implements Serializable{
	private int userId;
	private String userName;
	private String passWord;
	private int credits;
	private String latIp;
	private Date lastVisit;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String getLatIp() {
		return latIp;
	}
	public void setLatIp(String latIp) {
		this.latIp = latIp;
	}
	public Date getLastVisit() {
		return lastVisit;
	}
	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}
	
}
