package com.ata.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ata.bean.CredentialsBean;
import com.ata.dao.UserCredentialsDaoImpl;

@Repository
public class AuthImpl implements Authentication{

	@Autowired
	UserCredentialsDaoImpl ucdao;
	
	@Override
	public boolean authenticate(CredentialsBean credentialsBean) 
	{
		CredentialsBean cbdb = ucdao.findByID(credentialsBean.getUserID());
		
		if(cbdb==null || !cbdb.getPassword().equals(credentialsBean.getPassword()))
		{
			// userid or password is invalid
			return false;
		}
		else
			return true;  // valid user 
	}
	
	
	@Override
	public String authorize(String userID) 
	{
		CredentialsBean cbdb = ucdao.findByID(userID);
		if(cbdb!=null)
			return cbdb.getUserType(); // when user has an account return user type "A" or "C"
		else
			return null;	// else returning null
	}

	@Override
	public boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus)
	{
		try {
			
			CredentialsBean cb = ucdao.findByID(credentialsBean.getUserID());
				
			int cstatus = cb.getLoginStatus();
			if(cstatus != loginStatus)
			{
				cb.setLoginStatus(loginStatus);
				ucdao.update(cb);
				
				return true;
			}
		} catch (Exception e) {
			System.out.println("Exception occured at : AuthImpl : changeLoginStatus()");
			e.printStackTrace();
			return false;
		}
		
		return false;
	}

}
