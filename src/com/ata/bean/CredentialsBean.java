package com.ata.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name="ata_tbl_user_credentials")
public class CredentialsBean {
	@Id
	private String userID;
	
	private String password;
	
	private String userType;
	private int loginStatus=0;
	
	public CredentialsBean() {
		super();
	}
	public CredentialsBean(String userID, String password, String userType,
			int loginStatus) {
		super();
		this.userID = userID;
		this.password = password;
		this.userType = userType;
		this.loginStatus = loginStatus;
	}
	
	public CredentialsBean(String uid, String pass) 
	{
		userID = uid;
		password = pass;
	}
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public int getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}

}
